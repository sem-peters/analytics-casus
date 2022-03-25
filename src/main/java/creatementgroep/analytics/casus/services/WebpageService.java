package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.NewWebsiteData;
import creatementgroep.analytics.casus.domain.User;
import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.domain.Website;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class WebpageService {

    private final WebpageRepository webpageRepository;

    public Website findByTrackingId(String trackingId) {
        return webpageRepository.findByTrackingId(UUID.fromString(trackingId));
    }

    public List<Website> findAllByUser(User user) {
        return webpageRepository.findByUsersContaining(user);
    }

    public Website findById(Long id) {
        return webpageRepository.getById(id);
    }

    public void save(NewWebsiteData newWebsiteData, User user) {
        Website website = new Website(newWebsiteData.getName(), UUID.randomUUID(), newWebsiteData.getUrl(), user);
        webpageRepository.save(website);
    }

    public List<Website> findAllByUrl() {
        return webpageRepository.findAllByUrl();
    }

    @Scheduled(fixedRate = 5000)
    public void webpages(){
        RestTemplate restTemplate = new RestTemplate();
        for (Website website : webpageRepository.findAllByUrl()) {
            try {
                restTemplate.getForEntity(website.getUrl(), String.class);
                website.setStatus("UP");
            } catch (RestClientException e) {
                website.setStatus("DOWN");
            }
            website.setLastChecked(LocalDateTime.now());
            webpageRepository.save(website);
        }
        log.info("Check completed @ {}", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

    }

}

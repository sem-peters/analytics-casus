package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.NewWebsiteData;
import creatementgroep.analytics.casus.domain.User;
import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.domain.Website;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
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

}

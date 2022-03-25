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

	public Website findByTrackingId(String trackingId){
		return webpageRepository.findByTrackingId(UUID.fromString(trackingId));
	}

	public List<Website> findAll() {
		return webpageRepository.findAll();
	}

	public List<Website> findAllByUserId(Long userId){
		return webpageRepository.findAllByUserId(userId);
	}

	public Website findById(Long id) {
		return webpageRepository.getById(id);
	}

	public void save(NewWebsiteData newWebsiteData) {
		Website website = new Website(newWebsiteData.getName(), UUID.randomUUID());
		webpageRepository.save(website);
	}

}

package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.NewWebsiteData;
import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.domain.Website;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WebpageService {

	private final WebpageRepository wr;



//	public WebpageService(WebpageRepository wr) {
//		this.wr = wr;
//	}

	public Website findByTrackingId(String trackingId){
		return wr.findByTrackingId(UUID.fromString(trackingId));
	}

	public List<Website> findAll() {
		return wr.findAll();
	}

	public Website findById(Long id) {
		return wr.getById(id);
	}


	public void save(NewWebsiteData newWebsiteData) {
		Website website = new Website(newWebsiteData.getName(), UUID.randomUUID());
		wr.save(website);
	}

}

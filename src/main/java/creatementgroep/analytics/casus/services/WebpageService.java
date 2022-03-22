package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.domain.Website;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebpageService {
	private WebpageRepository wr;

	public WebpageService(WebpageRepository wr) {
		this.wr = wr;
	}

	public Website findByTrackingId(String trackingId){
		return wr.findByTrackingId(UUID.fromString(trackingId));
	}

}

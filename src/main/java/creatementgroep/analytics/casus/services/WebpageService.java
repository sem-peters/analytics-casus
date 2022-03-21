package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.WebpageRepository;
import org.springframework.stereotype.Service;

@Service
public class WebpageService {
	private WebpageRepository wr;

	public WebpageService(WebpageRepository wr) {
		this.wr = wr;
	}
}

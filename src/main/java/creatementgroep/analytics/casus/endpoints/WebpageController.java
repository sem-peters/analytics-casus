package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebpageController {

	private AnalyticsPageService aps;
	private AnalyticsRepository ar;

	public WebpageController(AnalyticsPageService aps, AnalyticsRepository ar) {
		this.aps = aps;
		this.ar = ar;
	}

	@GetMapping("/analytics")
	public List<PageVisit> getALlAuthorizations() {
		return ar.findAll();
	}
}

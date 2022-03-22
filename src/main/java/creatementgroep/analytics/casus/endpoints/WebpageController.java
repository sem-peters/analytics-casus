package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebpageController {

	private AnalyticsPageService aps;
	private AnalyticsRepository ar;
	private WebpageRepository wr;

	@Autowired
	public WebpageController(AnalyticsPageService aps, AnalyticsRepository ar, WebpageRepository wr) {
		this.aps = aps;
		this.ar = ar;
		this.wr = wr;
	}

	@GetMapping("/analytics")
	public List<PageVisit> getAllAnalytics() {
		return ar.findAll();
	}

	@GetMapping("/webpages")
	public List<Website> getAllWebpages() {
		return wr.findAll();
	}}

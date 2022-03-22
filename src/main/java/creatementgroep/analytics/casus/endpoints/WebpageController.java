package creatementgroep.analytics.casus.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnore;
import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.domain.WebpageRepository;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import creatementgroep.analytics.casus.services.WebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WebpageController {

private WebpageService wps;


	public WebpageController(WebpageService wps) {
	this.wps = wps;
	}




	@GetMapping("/webpages")
	public String webpages( Model model){
		List<Website> allWebsites = wps.findAll();
		model.addAttribute("webpages", allWebsites);
		return "webpages";
	}
}

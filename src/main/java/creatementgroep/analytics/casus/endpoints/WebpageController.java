package creatementgroep.analytics.casus.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnore;
import creatementgroep.analytics.casus.domain.*;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import creatementgroep.analytics.casus.services.WebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/webpages")
		public void createNewWebsite(@RequestBody NewWebsiteData newWebsiteData){
		wps.save(newWebsiteData);
	}
}

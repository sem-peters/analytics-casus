package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.*;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebpageController {

private WebpageService webpageService;

	@GetMapping("/webpages")
	public String webpages( Model model){
		List<Website> allWebsites = webpageService.findAll();
		model.addAttribute("webpages", allWebsites);
		return "webpages";
	}

	@PostMapping("/webpages")
		public void createNewWebsite(@RequestBody NewWebsiteData newWebsiteData){
		webpageService.save(newWebsiteData);
	}
}

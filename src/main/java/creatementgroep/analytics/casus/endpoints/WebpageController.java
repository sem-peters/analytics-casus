package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.*;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebpageController {

private final WebpageService webpageService;

	@GetMapping("/webpages")
	public String webpages( Model model){
		List<Website> allWebsites = webpageService.findAll();
		model.addAttribute("webpages", allWebsites);
		return "webpages";
	}

//	@PostMapping("/form")
//		public void createNewWebsite(@RequestBody NewWebsiteData newWebsiteData){
//		webpageService.save(newWebsiteData);
//	}





}

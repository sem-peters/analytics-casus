package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.*;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebpageController {

private final WebpageService webpageService;
private SecurityContext securityContext;

	@GetMapping("/webpages")
	public String webpages(@AuthenticationPrincipal User user, Model model){
		List<Website> allWebsites = webpageService.findAllByUser(user);
		model.addAttribute("webpages", allWebsites);
		System.out.printf("%d: %s, %s", user.getId(), user.getUsername(), user.getPassword());
		return "webpages";
	}

	@PostMapping("/webpages")
		public void createNewWebsite(@AuthenticationPrincipal User user,@RequestBody NewWebsiteData newWebsiteData){
		webpageService.save(newWebsiteData, user);

	}
}

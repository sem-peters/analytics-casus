package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.NewWebsiteData;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class WebController implements WebMvcConfigurer {

	private final WebpageService webpageService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/form").setViewName("form");
	}

	@GetMapping("/form")
	public String showForm(NewWebsiteData newWebsiteData) {
		return "form";
	}

	@PostMapping("/form")
	public String checkUrl(@Valid NewWebsiteData newWebsiteData, BindingResult bindingResult) {
		System.out.println(newWebsiteData);
		if (bindingResult.hasErrors()) {
			return "form";
		} else {
			webpageService.save(newWebsiteData);
		}

		return "redirect:/webpages";
	}
}

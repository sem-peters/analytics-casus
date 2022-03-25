package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AvailabilityController {

	private final WebpageService webpageService;

	@GetMapping("/availability")
	public List<Website> webpages(){
		return webpageService.findAllByUrl();
	}



}

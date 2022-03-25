package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class AvailabilityController {

	WebpageService webpageService;

	@GetMapping("/availability")
	public List<Website> webpages(){
		return webpageService.findAllByUrl();
	}



}

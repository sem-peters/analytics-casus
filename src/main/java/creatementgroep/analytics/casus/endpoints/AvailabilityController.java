package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
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
public class AvailabilityController {

	WebpageService webpageService;

	@GetMapping("/availability")
	@Scheduled(fixedRate = 5000)
	public List<Website> webpages(){
		RestTemplate restTemplate = new RestTemplate();
		for (Website website : webpageService.findAllByUrl()) {
			try {ResponseEntity<String> response
					= restTemplate.getForEntity(website.getUrl(), String.class);
				website.setStatus("UP");
			} catch (RestClientException e) {
				website.setStatus("DOWN");
			}
			website.setLastChecked(LocalDateTime.now());
		}
		System.out.printf("Check completed @ %s\n", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		return webpageService.findAllByUrl();
	}



}

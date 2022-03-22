package creatementgroep.analytics.casus;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.domain.Website;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}

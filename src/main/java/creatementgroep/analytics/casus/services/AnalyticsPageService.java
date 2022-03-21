package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnalyticsPageService {

	private AnalyticsRepository ar;

	@Autowired
	public AnalyticsPageService(AnalyticsRepository ar) {
		this.ar = ar;
	}

}

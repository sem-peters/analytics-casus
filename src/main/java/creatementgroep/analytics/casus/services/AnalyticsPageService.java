package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsPageService {


	private AnalyticsRepository ar;

	public AnalyticsPageService(AnalyticsRepository ar) {
		this.ar = ar;
	}

	public void savePageVisit( PageVisit pageVisit ) {
		ar.save(pageVisit);
	}
}

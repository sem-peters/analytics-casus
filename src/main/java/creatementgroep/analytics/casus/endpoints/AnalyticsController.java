package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.NewPageVisitData;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    public AnalyticsPageService aps;

    @Autowired
    public AnalyticsController(AnalyticsPageService aps) {
        this.aps = aps;
    }

    @PostMapping("/track")
    public void createPageVisit( NewPageVisitData newPageVisitData ) {

        PageVisit pageVisit = new PageVisit(newPageVisitData.getTimestamp(), newPageVisitData.getTrackingId());
        aps.savePageVisit(pageVisit);
    }


}

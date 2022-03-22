package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DataCollectionController {

    @Autowired
    private AnalyticsPageService analyticsPageService;

    @GetMapping("/track")
    public List<PageVisit> getPageVisits(){
       return null;
    }
}

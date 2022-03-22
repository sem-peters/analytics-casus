package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.NewPageVisitData;
import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import creatementgroep.analytics.casus.services.WebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class AnalyticsController {

    private AnalyticsPageService aps;
    private WebpageService wps;

    public AnalyticsController(AnalyticsPageService aps, WebpageService wps) {
        this.aps = aps;
        this.wps = wps;
    }

    @GetMapping("/track")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPageVisit(@RequestParam String trackingId ) {
        Website website = wps.findByTrackingId(trackingId);
        PageVisit pageVisit = new PageVisit(LocalDateTime.now(), website );
        aps.savePageVisit(pageVisit);
    }


}

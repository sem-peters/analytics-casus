package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.PageVisit;
import creatementgroep.analytics.casus.domain.Website;
import creatementgroep.analytics.casus.services.AnalyticsPageService;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class AnalyticsController {

    private AnalyticsPageService analyticsPageService;
    private WebpageService webpageService;

    @GetMapping("/analytics")
    public String pageVisits (@RequestParam Long id,Model model) {
        Website website = webpageService.findById(id);
        model.addAttribute("pagevisits", website.getPageVisits());
        return "pagevisits";
    }

    @GetMapping("/track")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPageVisit(@RequestParam String trackingId ) {
        Website website = webpageService.findByTrackingId(trackingId);
        PageVisit pageVisit = new PageVisit(LocalDateTime.now(), website );
        analyticsPageService.savePageVisit(pageVisit);
    }

    @RequestMapping(path="/analytics.csv")
    public void getAllPageVisitsInCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"pagevisit-analytics.csv\"");
        analyticsPageService.writePageVisitsToCSV(servletResponse.getWriter());
    }
}

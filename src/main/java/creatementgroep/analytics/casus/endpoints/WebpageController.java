package creatementgroep.analytics.casus.endpoints;

import creatementgroep.analytics.casus.domain.*;
import creatementgroep.analytics.casus.services.WebpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebpageController {

    private final WebpageService webpageService;

    @GetMapping("/webpages")
    public String webpages(@AuthenticationPrincipal User user, Model model) {
        List<Website> allWebsites = webpageService.findAllByUser(user);
        model.addAttribute("webpages", allWebsites);
        model.addAttribute("newWebsiteData", new NewWebsiteData());
        return "webpages";
    }

    @PostMapping("/webpages")
    public String createNewWebsite(@AuthenticationPrincipal User user,
                                   Model model,
                                   @ModelAttribute @Valid NewWebsiteData newWebsiteData,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Website> allWebsites = webpageService.findAllByUser(user);
            model.addAttribute("webpages", allWebsites);
            return "webpages";
        } else {
            webpageService.save(newWebsiteData, user);
        }
        return "redirect:/webpages";
    }
}

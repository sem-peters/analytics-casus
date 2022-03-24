package creatementgroep.analytics.casus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("");
        registry.addViewController("/track").setViewName("track");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/webpages").setViewName("webpages");
        registry.addViewController("/analytics").setViewName("analytics");
    }

}

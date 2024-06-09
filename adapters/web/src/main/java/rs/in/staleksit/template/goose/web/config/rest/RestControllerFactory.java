package rs.in.staleksit.template.goose.web.config.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rs.in.staleksit.template.goose.service.config.ApplicationServiceFactory;
import rs.in.staleksit.template.goose.service.geo.CountryService;
import rs.in.staleksit.template.goose.web.endpoint.CountryController;


@Configuration
@Import({
        ApplicationServiceFactory.class
})
public class RestControllerFactory {

    @Bean
    CountryController countryController(final CountryService countryService) {
        return new CountryController(countryService);
    }

}

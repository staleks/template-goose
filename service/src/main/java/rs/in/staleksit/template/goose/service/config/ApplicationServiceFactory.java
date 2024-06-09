package rs.in.staleksit.template.goose.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.in.staleksit.template.goose.service.geo.CountryPersistencePort;
import rs.in.staleksit.template.goose.service.geo.CountryService;
import rs.in.staleksit.template.goose.service.geo.CountryServiceImpl;

@Configuration
public class ApplicationServiceFactory {

    @Bean
    CountryService countryService(final CountryPersistencePort countryPersistencePort) {
        return new CountryServiceImpl(countryPersistencePort);
    }

}

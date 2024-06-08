package rs.in.staleksit.template.goose.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.in.staleksit.template.goose.persistence.geo.adapter.CountryPersistenceAdapter;
import rs.in.staleksit.template.goose.persistence.geo.repository.CountryRepository;
import rs.in.staleksit.template.goose.service.geo.CountryPersistencePort;

@Configuration
public class PersistenceConfig {
    //~ Geo
    @Bean
    CountryRepository countryRepository() {
        return new CountryRepository();
    }

    @Bean
    CountryPersistencePort countryPersistencePort(final CountryRepository countryRepository) {
        return new CountryPersistenceAdapter(countryRepository);
    }

}

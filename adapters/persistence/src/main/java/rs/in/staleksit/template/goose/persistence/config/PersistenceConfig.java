package rs.in.staleksit.template.goose.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rs.in.staleksit.template.goose.persistence.geo.adapter.CountryPersistenceAdapter;
import rs.in.staleksit.template.goose.persistence.geo.repository.JpaCountryRepository;
import rs.in.staleksit.template.goose.service.geo.CountryPersistencePort;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "rs.in.staleksit.template.goose.persistence.geo.model")
@EnableJpaRepositories(basePackages = "rs.in.staleksit.template.goose.persistence.geo.repository")
public class PersistenceConfig {

  /**
   * Translates {@link org.hibernate.HibernateException} instances to Spring's {@link
   * org.springframework.dao.DataAccessException} hierarchy.
   *
   * @return {@link HibernateExceptionTranslator}
   */
  @Bean
  public HibernateExceptionTranslator hibernateExceptionTranslator() {
    return new HibernateExceptionTranslator();
  }

  @Bean
  CountryPersistencePort countryPersistencePort(final JpaCountryRepository countryRepository) {
    return new CountryPersistenceAdapter(countryRepository);
  }
}

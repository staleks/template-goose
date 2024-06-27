package rs.in.staleksit.template.goose.persistence.geo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rs.in.staleksit.template.goose.persistence.geo.model.JpaCountry;

@Repository
public interface JpaCountryRepository extends PagingAndSortingRepository<JpaCountry, Long> {}

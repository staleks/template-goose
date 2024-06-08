package rs.in.staleksit.template.goose.persistence.geo.adapter;

import lombok.RequiredArgsConstructor;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.persistence.geo.repository.CountryRepository;
import rs.in.staleksit.template.goose.service.geo.CountryPersistencePort;

import java.util.Set;

@RequiredArgsConstructor
public class CountryPersistenceAdapter implements CountryPersistencePort {

    private final CountryRepository countryRepository;

    @Override
    public Set<Country> findAll() {
        return countryRepository.findAll();
    }
}

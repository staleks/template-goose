package rs.in.staleksit.template.goose.service.geo;

import lombok.RequiredArgsConstructor;
import rs.in.staleksit.template.goose.domain.model.geo.Country;

import java.util.Set;
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryPersistencePort countryPersistencePort;

    @Override
    public Set<Country> findAll() {
        return countryPersistencePort.findAll();
    }

}

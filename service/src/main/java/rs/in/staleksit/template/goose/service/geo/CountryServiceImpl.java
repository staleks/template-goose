package rs.in.staleksit.template.goose.service.geo;

import lombok.RequiredArgsConstructor;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

import java.util.Set;
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryPersistencePort countryPersistencePort;

    @Override
    public PagingResponse<Country> findAll(final PagingRequest pagingRequest) {
        return countryPersistencePort.findAll(pagingRequest);
    }
}

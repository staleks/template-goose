package rs.in.staleksit.template.goose.service.geo;

import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

public interface CountryPersistencePort {
  PagingResponse<Country> findAll(final PagingRequest pagingRequest);
}

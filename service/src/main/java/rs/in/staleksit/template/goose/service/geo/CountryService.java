package rs.in.staleksit.template.goose.service.geo;

import rs.in.staleksit.template.goose.domain.model.geo.Country;

import java.util.Set;

public interface CountryService {

    Set<Country> findAll();

}

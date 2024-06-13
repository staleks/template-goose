package rs.in.staleksit.template.goose.persistence.geo.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.persistence.geo.model.JpaCountry;
import rs.in.staleksit.template.goose.persistence.geo.repository.JpaCountryRepository;
import rs.in.staleksit.template.goose.service.geo.CountryPersistencePort;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

import static rs.in.staleksit.template.goose.persistence.geo.mapper.JpaCountryMapper.COUNTRY_PERSISTENCE_MAPPER;

@RequiredArgsConstructor
public class CountryPersistenceAdapter implements CountryPersistencePort {

    private final JpaCountryRepository countryRepository;

    @Override
    public PagingResponse<Country> findAll(final PagingRequest pagingRequest) {
        Page<JpaCountry> dbCountries = countryRepository.findAll(pagingRequest.toPageable());
        return new PagingResponse<>(dbCountries, COUNTRY_PERSISTENCE_MAPPER::jpaEntityToDomain);
    }

}

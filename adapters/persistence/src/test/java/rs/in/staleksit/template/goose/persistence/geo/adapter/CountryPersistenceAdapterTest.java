package rs.in.staleksit.template.goose.persistence.geo.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.persistence.geo.model.JpaCountry;
import rs.in.staleksit.template.goose.persistence.geo.repository.JpaCountryRepository;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static rs.in.staleksit.template.goose.persistence.geo.mapper.JpaCountryMapper.COUNTRY_PERSISTENCE_MAPPER;

@ExtendWith(MockitoExtension.class)
class CountryPersistenceAdapterTest {

    @Mock
    private JpaCountryRepository countryRepository;

    @InjectMocks
    private CountryPersistenceAdapter countryPersistenceAdapter;

    @Test
    void testFindAll_noResults() {
        //~ given
        PagingResponse<Country> countryPagingResponse = new PagingResponse<>(Collections.emptyList(), 0, 0, 0, 0);
        Page<JpaCountry> dbCountries = Page.empty();
        when(countryRepository.findAll(isA(Pageable.class))).thenReturn(dbCountries);

        //~ when
        PagingResponse<Country> result = countryPersistenceAdapter.findAll(PagingRequest.of(0, 10, "name"));

        //~ then
        assertTrue(result.getItems().isEmpty());
        verify(countryRepository).findAll(isA(Pageable.class));
    }

    @Test
    void testFindAll_haveResults() {
        //~ given
        Set<Country> testCountries = new HashSet<>();
        testCountries.add(Country.create("john.doe@test.com", "United States of America", "US", "USA"));
        testCountries.add(Country.create("john.doe@test.com", "Canada", "CA", "CAN"));

        List<JpaCountry> jpaCountryList = new ArrayList<>();
        Country usa = Country.create("john.doe@test.com", "United States of America", "US", "USA");
        JpaCountry jpaUsa = COUNTRY_PERSISTENCE_MAPPER.domainToJpaEntity(usa);
        jpaCountryList.add(jpaUsa);

        Page<JpaCountry> dbCountries = new PageImpl<>(jpaCountryList, PagingRequest.of(0, 10, "name").toPageable(), 1L);

        when(countryRepository.findAll(isA(Pageable.class))).thenReturn(dbCountries);

        //~ when
        PagingResponse<Country> result = countryPersistenceAdapter.findAll(PagingRequest.of(0, 10, "name"));

        //~ then
        assertFalse(result.getItems().isEmpty());
        Assertions.assertEquals(1, result.getItems().size());
        verify(countryRepository).findAll(isA(Pageable.class));
    }


}

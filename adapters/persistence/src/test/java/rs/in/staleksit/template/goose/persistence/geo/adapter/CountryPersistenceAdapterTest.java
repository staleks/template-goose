package rs.in.staleksit.template.goose.persistence.geo.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.persistence.geo.repository.CountryRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryPersistenceAdapterTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryPersistenceAdapter countryPersistenceAdapter;

    @Test
    void testFindAll_noResults() {
        //~ given
        Set<Country> emptyResultTest = Collections.emptySet();
        when(countryRepository.findAll()).thenReturn(emptyResultTest);

        //~ when
        Set<Country> result = countryPersistenceAdapter.findAll();

        //~ then
        assertTrue(result.isEmpty());
        verify(countryRepository).findAll();
    }

    @Test
    void testFindAll_haveResults() {
        //~ given
        Set<Country> testCountries = new HashSet<>();
        testCountries.add(Country.create("john.doe@test.com", "United States of America", "US", "USA"));
        testCountries.add(Country.create("john.doe@test.com", "Canada", "CA", "CAN"));
        when(countryRepository.findAll()).thenReturn(testCountries);

        //~ when
        Set<Country> result = countryPersistenceAdapter.findAll();

        //~ then
        assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
        verify(countryRepository).findAll();
    }


}

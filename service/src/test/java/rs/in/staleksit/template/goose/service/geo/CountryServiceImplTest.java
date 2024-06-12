package rs.in.staleksit.template.goose.service.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.in.staleksit.template.goose.domain.model.geo.Country;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryServiceImplTest {

    @Mock
    private CountryPersistencePort countryPersistencePort;

    //~ class under test
    private CountryServiceImpl countryService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        countryService = new CountryServiceImpl(countryPersistencePort);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void testFindAll_noResults() {
        //~ given
        when(countryPersistencePort.findAll()).thenReturn(Collections.emptySet());
        //~ when
        Set<Country> result = countryService.findAll();
        //~  then
        assertTrue(result.isEmpty());
        verify(countryPersistencePort).findAll();
    }

}

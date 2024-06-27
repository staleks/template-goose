package rs.in.staleksit.template.goose.service.geo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

@ExtendWith(MockitoExtension.class)
class CountryServiceImplTest {

  @Mock private CountryPersistencePort countryPersistencePort;

  // ~ class under test
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
    // ~ given
    PagingResponse<Country> countryPagingResponse =
        new PagingResponse<>(Collections.emptyList(), 0, 0, 0, 0);
    when(countryPersistencePort.findAll(isA(PagingRequest.class)))
        .thenReturn(countryPagingResponse);
    // ~ when
    PagingResponse<Country> result = countryService.findAll(PagingRequest.of(0, 10, "name"));
    // ~  then
    assertTrue(result.getItems().isEmpty());
    verify(countryPersistencePort).findAll(isA(PagingRequest.class));
  }
}

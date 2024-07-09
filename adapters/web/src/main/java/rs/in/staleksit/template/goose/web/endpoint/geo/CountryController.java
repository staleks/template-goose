package rs.in.staleksit.template.goose.web.endpoint.geo;

import static org.springframework.http.ResponseEntity.ok;
import static rs.in.staleksit.template.goose.service.paging.PagingRequest.PARAM_PAGE;
import static rs.in.staleksit.template.goose.service.paging.PagingRequest.PARAM_SIZE;
import static rs.in.staleksit.template.goose.service.paging.PagingRequest.PARAM_SORT;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.service.geo.CountryService;
import rs.in.staleksit.template.goose.service.paging.PagingRequest;
import rs.in.staleksit.template.goose.service.paging.PagingResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CountryController {

  private static final String COUNTRIES_ENDPOINT = "/geo/v1/countries";

  private final CountryService countryService;

  @GetMapping(path = COUNTRIES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PagingResponse<Country>> fetchAll(
      @RequestParam(value = PARAM_PAGE, required = false) Integer page,
      @RequestParam(value = PARAM_SIZE, required = false) Integer size,
      @RequestParam(value = PARAM_SORT, required = false) String sort) {
    log.info("Fetch all Countries [page: {}, size: {}, sort: {}", page, size, sort);
    return ok(countryService.findAll(PagingRequest.of(page, size, sort)));
  }
}

package rs.in.staleksit.template.goose.persistence.geo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import rs.in.staleksit.template.goose.domain.model.geo.Country;
import rs.in.staleksit.template.goose.persistence.geo.model.JpaCountry;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JpaCountryMapper {

    JpaCountryMapper COUNTRY_PERSISTENCE_MAPPER = Mappers.getMapper(JpaCountryMapper.class);

    Country jpaEntityToDomain(final JpaCountry jpaCountry);

    JpaCountry domainToJpaEntity(final Country country);

}

package ar.com.ada.courseplatform.model.mapper.circular.dependency;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyCycleMapper extends DataCycleMapper<CompanyDTO, Company> {
    CompanyCycleMapper MAPPER = Mappers.getMapper(CompanyCycleMapper.class);
}

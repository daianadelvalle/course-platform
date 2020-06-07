package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends CycleDataMapper<CompanyDTO, Company> {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);
}

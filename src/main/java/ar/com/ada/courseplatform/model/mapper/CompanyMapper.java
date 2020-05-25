package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface CompanyMapper extends CycleDataMapper<CompanyDTO, Company> {

    @Override
    Company toEntity(CompanyDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<Company> toEntity(List<CompanyDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    CompanyDTO toDto(Company entity, CycleAvoidingMappingContext context);

    @Override
    List<CompanyDTO> toDto(List<Company> entityList, CycleAvoidingMappingContext context);
}

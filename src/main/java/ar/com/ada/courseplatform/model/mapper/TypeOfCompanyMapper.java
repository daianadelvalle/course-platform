package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface TypeOfCompanyMapper extends CycleDataMapper<TypeOfCompanyDTO, TypeOfCompany> {

    @Override
    TypeOfCompany toEntity(TypeOfCompanyDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<TypeOfCompany> toEntity(List<TypeOfCompanyDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    TypeOfCompanyDTO toDto(TypeOfCompany entity, CycleAvoidingMappingContext context);

    @Override
    List<TypeOfCompanyDTO> toDto(List<TypeOfCompany> entityList, CycleAvoidingMappingContext context);
}

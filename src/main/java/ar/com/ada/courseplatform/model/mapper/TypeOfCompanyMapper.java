package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TypeOfCompanyMapper extends CycleDataMapper<TypeOfCompanyDTO, TypeOfCompany> {
    TypeOfCompanyMapper MAPPER = Mappers.getMapper(TypeOfCompanyMapper.class);
}

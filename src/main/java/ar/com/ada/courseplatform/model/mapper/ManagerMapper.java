package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Manager;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerMapper extends CycleDataMapper<ManagerDTO, Manager> {
    ManagerMapper MAPPER = Mappers.getMapper(ManagerMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "companyId", ignore = true)
    ManagerDTO toDto(Manager entity, @Context CycleAvoidingMappingContext context);
}

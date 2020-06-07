package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerMapper extends CycleDataMapper<ManagerDTO, Manager> {
    ManagerMapper MAPPER = Mappers.getMapper(ManagerMapper.class);
}

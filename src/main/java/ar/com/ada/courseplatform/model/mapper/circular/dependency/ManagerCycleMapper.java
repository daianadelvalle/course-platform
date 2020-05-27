package ar.com.ada.courseplatform.model.mapper.circular.dependency;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerCycleMapper extends DataCycleMapper<ManagerDTO, Manager> {
    ManagerCycleMapper MAPPER = Mappers.getMapper(ManagerCycleMapper.class);
}

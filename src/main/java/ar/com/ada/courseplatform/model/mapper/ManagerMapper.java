package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Manager;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ManagerMapper extends CycleDataMapper<ManagerDTO, Manager> {

    @Override
    Manager toEntity(ManagerDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<Manager> toEntity(List<ManagerDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    ManagerDTO toDto(Manager entity, CycleAvoidingMappingContext context);

    @Override
    List<ManagerDTO> toDto(List<Manager> entityList, CycleAvoidingMappingContext context);
}

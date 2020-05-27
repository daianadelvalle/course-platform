package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioEconomicStudyCycleMapper extends CycleDataMapper<SocioEconomicStudyDTO, SocioEconomicStudy> {
    SocioEconomicStudyCycleMapper MAPPER = Mappers.getMapper(SocioEconomicStudyCycleMapper.class);
}

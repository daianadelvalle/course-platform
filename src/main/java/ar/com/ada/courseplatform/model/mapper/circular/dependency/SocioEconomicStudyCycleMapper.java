package ar.com.ada.courseplatform.model.mapper.circular.dependency;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioEconomicStudyCycleMapper extends DataCycleMapper<SocioEconomicStudyDTO, SocioEconomicStudy> {
    SocioEconomicStudyCycleMapper MAPPER = Mappers.getMapper(SocioEconomicStudyCycleMapper.class);
}

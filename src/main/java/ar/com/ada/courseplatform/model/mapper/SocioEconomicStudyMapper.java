package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioEconomicStudyMapper extends CycleDataMapper<SocioEconomicStudyDTO, SocioEconomicStudy> {
    SocioEconomicStudyMapper MAPPER = Mappers.getMapper(SocioEconomicStudyMapper.class);
}

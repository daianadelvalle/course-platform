package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface SocioEconomicStudyMapper extends CycleDataMapper<SocioEconomicStudyDTO, SocioEconomicStudy> {

    @Override
    SocioEconomicStudy toEntity(SocioEconomicStudyDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<SocioEconomicStudy> toEntity(List<SocioEconomicStudyDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    SocioEconomicStudyDTO toDto(SocioEconomicStudy entity, CycleAvoidingMappingContext context);

    @Override
    List<SocioEconomicStudyDTO> toDto(List<SocioEconomicStudy> entityList, CycleAvoidingMappingContext context);
}

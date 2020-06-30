package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioEconomicStudyMapper extends CycleDataMapper<SocioEconomicStudyDTO, SocioEconomicStudy> {
    SocioEconomicStudyMapper MAPPER = Mappers.getMapper(SocioEconomicStudyMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "studentId", ignore = true)
    SocioEconomicStudyDTO toDto(SocioEconomicStudy entity, @Context CycleAvoidingMappingContext context);
}

package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.SocioEconomicStudyMapper;
import ar.com.ada.courseplatform.model.repository.SocioEconomicStudyRepository;
import ar.com.ada.courseplatform.service.security.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socioEconomicStudyServices")
public class SocioEconomicStudyServices implements Services<SocioEconomicStudyDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("socioEconomicStudyRepository")
    private SocioEconomicStudyRepository socioEconomicStudyRepository;

    private final SocioEconomicStudyMapper socioEconomicStudyMapper = SocioEconomicStudyMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<SocioEconomicStudyDTO> findAll() {
        return null;
    }

    @Override
    public SocioEconomicStudyDTO save(SocioEconomicStudyDTO dto) {
        SocioEconomicStudy socioEconomicStudyToSave = socioEconomicStudyMapper.toEntity(dto, context);
        SocioEconomicStudy socioEconomicStudySaved = socioEconomicStudyRepository.save(socioEconomicStudyToSave);
        SocioEconomicStudyDTO socioEconomicStudyDTOtoSaved = socioEconomicStudyMapper.toDto(socioEconomicStudySaved, context);

        return socioEconomicStudyDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}

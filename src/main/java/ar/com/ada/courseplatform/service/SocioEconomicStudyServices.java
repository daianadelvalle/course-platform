package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.SocioEconomicStudyCycleMapper;
import ar.com.ada.courseplatform.model.repository.SocioEconomicStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//public class SocioEconomicStudyServices implements Services<SocioEconomicStudyDTO> {
//
////    @Autowired
////    @Qualifier("businessLogicExceptionComponent")
////    private BusinessLogicExceptionComponent logicExceptionComponent;
////
////    @Autowired @Qualifier("socioEconomicStudyRepository")
////    private SocioEconomicStudyRepository socioEconomicStudyRepository;
////
////    private SocioEconomicStudyCycleMapper managerCycleMapper = SocioEconomicStudyCycleMapper.MAPPER;
////
////    @Autowired @Qualifier("cycleAvoidingMappingContext")
////    private CycleAvoidingMappingContext context;
////
////
////    @Override
////    public List<SocioEconomicStudyDTO> findAll() {
////        return null;
////    }
////
////    @Override
////    public SocioEconomicStudyDTO save(SocioEconomicStudyDTO dto) {
////        return null;
////    }
////
////    @Override
////    public void delete(Long id) {
////
////    }
////}

package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.ManagerCycleMapper;
import ar.com.ada.courseplatform.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//public class ManagerServices implements Services<ManagerDTO> {
//
//    @Autowired
//    @Qualifier("businessLogicExceptionComponent")
//    private BusinessLogicExceptionComponent logicExceptionComponent;
//
//    @Autowired @Qualifier("managerRepository")
//    private ManagerRepository managerRepository;
//
//    private ManagerCycleMapper managerCycleMapper = ManagerCycleMapper.MAPPER;
//
//    @Autowired @Qualifier("cycleAvoidingMappingContext")
//    private CycleAvoidingMappingContext context;
//
//    @Override
//    public List<ManagerDTO> findAll() {
//        return null;
//    }
//
//    @Override
//    public ManagerDTO save(ManagerDTO dto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}

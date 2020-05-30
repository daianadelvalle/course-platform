package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.mapper.CompanyCycleMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("companyServices")
//public class CompanyServices implements Services<CompanyDTO> {
//
//    @Autowired @Qualifier("businessLogicExceptionComponent")
//    private BusinessLogicExceptionComponent logicExceptionComponent;
//
//    @Autowired @Qualifier("companyRepository")
//    private CompanyRepository companyRepository;
//
//    private CompanyCycleMapper companyCycleMapper = CompanyCycleMapper.MAPPER;
//
//    @Autowired @Qualifier("cycleAvoidingMappingContext")
//    private CycleAvoidingMappingContext context;
//
//    @Override
//    public List<CompanyDTO> findAll() {
//        return null;
//    }
//
//    @Override
//    public CompanyDTO save(CompanyDTO dto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}

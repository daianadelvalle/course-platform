package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.StudentCycleMapper;
import ar.com.ada.courseplatform.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//public class StudentServices implements Services<StudentDTO> {
//
//    @Autowired
//    @Qualifier("businessLogicExceptionComponent")
//    private BusinessLogicExceptionComponent logicExceptionComponent;
//
//    @Autowired @Qualifier("studentRepository")
//    private StudentRepository studentRepository;
//
//    private StudentCycleMapper studentCycleMapper = StudentCycleMapper.MAPPER;
//
//    @Autowired @Qualifier("cycleAvoidingMappingContext")
//    private CycleAvoidingMappingContext context;
//
//    @Override
//    public List<StudentDTO> findAll() {
//        return null;
//    }
//
//    @Override
//    public StudentDTO save(StudentDTO dto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}

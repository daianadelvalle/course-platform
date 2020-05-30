package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.StudentHasCourseCycleMapper;
import ar.com.ada.courseplatform.model.repository.StudentHasCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//public class StudentHasCourseServices implements Services<StudentHasCourseDTO> {
//
//    @Autowired
//    @Qualifier("businessLogicExceptionComponent")
//    private BusinessLogicExceptionComponent logicExceptionComponent;
//
//    @Autowired @Qualifier("studentHasCourseRepository")
//    private StudentHasCourseRepository studentHasCourseRepository;
//
//    private StudentHasCourseCycleMapper studentHasCourseCycleMapper = StudentHasCourseCycleMapper.MAPPER;
//
//    @Autowired @Qualifier("cycleAvoidingMappingContext")
//    private CycleAvoidingMappingContext context;
//
//
//    @Override
//    public List<StudentHasCourseDTO> findAll() {
//        return null;
//    }
//
//    @Override
//    public StudentHasCourseDTO save(StudentHasCourseDTO dto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}

package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServices")
public class CourseServices implements Services<CourseDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    private CourseCycleMapper courseCycleMapper = CourseCycleMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<CourseDTO> findAll() {
        return null;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

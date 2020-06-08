package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.mapper.CourseMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CourseRepository;
import ar.com.ada.courseplatform.service.security.Services;
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

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<CourseDTO> findAll() {
        return null;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        Course courseToSaved = courseMapper.toEntity(dto, context);
        Course courseSaved = courseRepository.save(courseToSaved);
        CourseDTO courseDTOtoSaved = courseMapper.toDto(courseSaved, context);

        return courseDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}

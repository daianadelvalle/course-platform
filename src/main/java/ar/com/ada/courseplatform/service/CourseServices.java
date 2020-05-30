package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.mapper.CourseCycleMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServices")
public class CourseServices implements Services<CourseDTO> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    private CourseCycleMapper courseCycleMapper = CourseCycleMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courseEntityList = courseRepository.findAll();
        List<CourseDTO> courseDTOList = courseCycleMapper.toDto(courseEntityList, context);
        return courseDTOList;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

//    public List<CourseDTO> findAllAvailables() {
//        List<Course> courseEntityList = (List<Course>) courseRepository.findAll()
//                .stream().filter(course -> course.getQuota() != course.getDirectAward() + course.getScolarshipAccountant());
//        List<CourseDTO> courseDTOList = courseCycleMapper.toDto(courseEntityList, context);
//        return courseDTOList;
//    }

    public List<CourseDTO> findAllCourseForCategory() {
        return null;
    }

    public List<CourseDTO> findAllCoursesForCompanies() {
        return null;
    }

    public List<CourseDTO> findAllCoursesForStudentsInProgress() {
        return null;
    }

    public List<CourseDTO> findAllCoursesForStudentsFinalizaded() {
        return null;
    }

    public CourseDTO findCourseById(Long id) {
        return null;
    }
}

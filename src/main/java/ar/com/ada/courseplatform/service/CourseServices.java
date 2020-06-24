package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.mapper.CourseMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
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

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<CourseDTO> findAll() {
        List<Course> all = courseRepository.findAll();
        List<CourseDTO> courseDTOList = courseMapper.toDto(all, context);
        return courseDTOList;
    }

    public CourseDTO findCompanyById(Long id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Course", id));
        CourseDTO courseDTO  = courseMapper.toDto(course, context);
        return courseDTO;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        Long companyId = dto.getCompanyId();
        Company company = companyRepository
                .findById(companyId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Company", companyId));
        Course courseToSaved = courseMapper.toEntity(dto, context);
        courseToSaved.setCompany(company);

        Integer directAward = courseToSaved.getQuota() -courseToSaved.getScolarship();
        courseToSaved.setDirectAward(directAward);

        Course courseSaved = courseRepository.save(courseToSaved);
        CourseDTO courseDTOtoSaved = courseMapper.toDto(courseSaved, context);

        return courseDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}

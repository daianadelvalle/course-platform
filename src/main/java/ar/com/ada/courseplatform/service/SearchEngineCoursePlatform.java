package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.mapper.CourseMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchEngineCoursePlatform")
public class SearchEngineCoursePlatform {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    public List<CourseDTO> getAllCourseAvailable(String available, Integer page) {
        Page<Course> allCoursesAvailablePage = courseRepository
                .findCourseByAvailableQuota(Boolean.valueOf(available), PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCourseAvailable = allCoursesAvailablePage.getContent();
        List<CourseDTO> allCourseAvailableListDTO = courseMapper.toDto(allCourseAvailable, context);

        return allCourseAvailableListDTO;
    }

    public List<CourseDTO> getAllCoursesByCategory(String category, Integer page) {
        Page<Course> allCoursesByCategoryPage = courseRepository.findAllCoursesByCategory(category, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCoursesByCategory = allCoursesByCategoryPage.getContent();
        List<CourseDTO> allCoursesByCategoryDTO = courseMapper.toDto(allCoursesByCategory, context);

        return allCoursesByCategoryDTO;
    }

    public List<CourseDTO> getAllCoursesByCompany(Long companyId, Integer page) {
        Page<Course> allCoursesByCompanyPage = courseRepository.findAllCoursesByCompany(companyId, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCoursesByCompany = allCoursesByCompanyPage.getContent();
        List<CourseDTO> allCoursesByCompanyDTO = courseMapper.toDto(allCoursesByCompany, context);

        return allCoursesByCompanyDTO;
    }

    public List<CourseDTO> getAllCoursesByStudentsInProgress(String finalized, Integer page) {
        Page<Course> allCoursesWithStudentsInProgressPage = courseRepository
                .findAllCoursesByStudentsInProgress(Boolean.valueOf(finalized), PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCoursesWithStudentsInProgress = allCoursesWithStudentsInProgressPage.getContent();
        List<CourseDTO> allCoursesWithStudentsInProgressDTO = courseMapper.toDto(allCoursesWithStudentsInProgress, context);

        return allCoursesWithStudentsInProgressDTO;
    }

    public List<CourseDTO> getAllCoursesByStudentsFinalized(String finalized, Integer page) {
        Page<Course> allCoursesWithStudentsFinalizedPage = courseRepository
                .findAllCoursesByStudentsFinalized(Boolean.valueOf(finalized), PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCoursesWithStudentsFinalized = allCoursesWithStudentsFinalizedPage.getContent();
        List<CourseDTO> allCoursesWithStudentsFinalizedDTO = courseMapper.toDto(allCoursesWithStudentsFinalized, context);

        return allCoursesWithStudentsFinalizedDTO;
    }

    public List<CourseDTO> getAllCoursesByCompanyAndCategory(Long companyId, String category, Integer page) {
        Page<Course> allCoursesByCompanyAndCategoryPage = courseRepository
                .findAllCoursesByCompanyAndCategory(companyId, category, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allCoursesByCompanyAndCategory = allCoursesByCompanyAndCategoryPage.getContent();
        List<CourseDTO> allCoursesByCompanyAndCategoryDTO = courseMapper.toDto(allCoursesByCompanyAndCategory, context);

        return allCoursesByCompanyAndCategoryDTO;
    }
}

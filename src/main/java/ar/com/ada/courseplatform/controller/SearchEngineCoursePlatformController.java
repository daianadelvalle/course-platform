package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.service.SearchEngineCoursePlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class SearchEngineCoursePlatformController {

    @Autowired
    @Qualifier("searchEngineCoursePlatform")
    private SearchEngineCoursePlatform searchEngineCoursePlatform;

    // http://localhost:8080/search/courses/true?page=0
    @GetMapping({"/courses/availables/{available}", "/courses/availables/{finalized}/"})
    public ResponseEntity getAllCourseAvailables(@RequestParam Optional<Integer> page, @PathVariable String available) {

        List<CourseDTO> allCourseAivalables = searchEngineCoursePlatform
                .getAllCourseAvailable(available, page.orElse(0));

        return ResponseEntity.ok(allCourseAivalables);
    }

    // http://localhost:8080/search/courses/category/sistemas?page=0
    @GetMapping({"/courses/category/{category}", "/courses/category/{category}/"})
    public ResponseEntity getAllCoursesByCategory(@RequestParam Optional<Integer> page, @PathVariable String category) {

        List<CourseDTO> allCoursesByCategory = searchEngineCoursePlatform
                .getAllCoursesByCategory(category, page.orElse(0));

        return ResponseEntity.ok(allCoursesByCategory);
    }

    // http://localhost:8080/search/courses/companies/1?page=0
    @GetMapping({"/courses/companies/{companyId}", "/courses/companies/{companyId}/"})
    public ResponseEntity getAllCoursesByCompany(@RequestParam Optional<Integer> page, @PathVariable Long companyId) {

        List<CourseDTO> allCoursesByCompany = searchEngineCoursePlatform.getAllCoursesByCompany(companyId, page.orElse(0));

        return ResponseEntity.ok(allCoursesByCompany);
    }

    // http://localhost:8080/search/courses/students/finalized/false?page=0
    @GetMapping({"/courses/students/finalized/{finalized}", "/courses/students/finalized/{finalized}/"})
    public ResponseEntity getAllCoursesWithStudentsInProgress(@RequestParam Optional<Integer> page, @PathVariable String finalized) {

        List<CourseDTO> allCoursesWithStudentsInProgress = searchEngineCoursePlatform
                .getAllCoursesByStudentsInProgress(finalized, page.orElse(0));

        return ResponseEntity.ok(allCoursesWithStudentsInProgress);
    }

    // http://localhost:8080/search/courses/students/finalized/true?page=0
    @GetMapping({"/courses/finalized/{finalized}", "/courses/students/finalized/{finalized}/"})
    public ResponseEntity getAllCoursesWithStudentsFinalized(@RequestParam Optional<Integer> page, @PathVariable String finalized) {

        List<CourseDTO> alloursesWithStudentsFinalized = searchEngineCoursePlatform
                .getAllCoursesByStudentsFinalized(finalized, page.orElse(0));

        return ResponseEntity.ok(alloursesWithStudentsFinalized);
    }

    // http://localhost:8080/search/courses/company/1/category/sistemas?page=0
    @GetMapping({"/courses/company/{companyId}/category/{category}", "/courses/company/{companyId}/category/{category}/"})
    public ResponseEntity getAllCoursesByCompanyAndCategory(@RequestParam Optional<Integer> page, @PathVariable Long companyId, @PathVariable String category) {

        List<CourseDTO> allCourseByCompanyAndCategory = searchEngineCoursePlatform
                .getAllCoursesByCompanyAndCategory(companyId, category, page.orElse(0));

        return ResponseEntity.ok(allCourseByCompanyAndCategory);
    }


}

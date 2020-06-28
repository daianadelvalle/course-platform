package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.service.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    @Qualifier("courseServices")
    private CourseServices courseServices;

    @GetMapping({"", "/"}) // localhost:8080/courses y localhost:8080/courses/ [GET]
    public ResponseEntity getAllCourses() {
        List<CourseDTO> all = courseServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"}) // localhost:8080/courses/1 y localhost:8080/courses/1/ [GET]
    public ResponseEntity getCourseById(@PathVariable Long id) {
        CourseDTO courseById = courseServices.findCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping({"", "/"}) // localhost:8080/courses y localhost:8080/courses/
    public ResponseEntity addNewCourse(@Valid @RequestBody CourseDTO courseDTO) throws URISyntaxException {
        CourseDTO courseSaved = courseServices.save(courseDTO);
        return ResponseEntity
                .created(new URI("/courses/" + courseDTO.getId()))
                .body(courseSaved);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping({"/{id}", "/{id}/"}) // localhost:8080/courses/1 y localhost:8080/courses/1/ [DELETE]
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

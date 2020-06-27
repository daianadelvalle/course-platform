package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.service.StudentHasCourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/request-to-courses")
public class StudentHasCourseController {

    @Autowired
    private StudentHasCourseServices studentHasCourseServices;

    // localhost:8080/request-to-courses/students/1/courses/1 y localhost:8080/request-to-courses/students/1/courses/1 [PUT]
    @PutMapping({"/students/{studentId}/courses/{courseId}", "/students/{studentId}/courses/{courseId}/"})
    public ResponseEntity addRequestToCourse(
            @Valid @RequestBody StudentHasCourseDTO studentHasCourseDTO,
            @PathVariable Long studentId, @PathVariable Long courseId) {
        StudentHasCourseDTO studentHasCourseDTOSaved = studentHasCourseServices.requestToCourse(studentHasCourseDTO, studentId, courseId);
        return ResponseEntity.ok(studentHasCourseDTOSaved);
    }
}

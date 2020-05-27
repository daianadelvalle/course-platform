package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.service.StudentHasCourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/students-has-courses")
public class StudentHasCourseController {

    @Autowired
    @Qualifier("studentHasCourseServices")
    private StudentHasCourseServices studentHasCourseServices;

    @GetMapping({"", "/"}) // localhost:8080/students-has-courses y localhost:8080/students-has-courses/ [GET]
    public ResponseEntity getAllStudentHasCourse() {
        List<StudentHasCourseDTO> all = studentHasCourseServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"})
    // localhost:8080/students-has-courses/1 y localhost:8080/students-has-courses/1/ [GET]
    public ResponseEntity getStudentHasCourseById(@PathVariable Long id) {
        StudentHasCourseDTO studentHasCourseById = studentHasCourseServices.findStudentHasCourseById(id);
        return ResponseEntity.ok(studentHasCourseById);

    }

    @PostMapping({"", "/"}) // localhost:8080/students-has-courses y localhost:8080/students-has-courses/ [POST]
    public ResponseEntity addNewStudentHasCourse(@Valid @RequestBody StudentHasCourseDTO studentHasCourseDTO) throws URISyntaxException {
        StudentHasCourseDTO studentHasCourseSaved = studentHasCourseServices.save(studentHasCourseDTO);
        return ResponseEntity
                .created(new URI("/students-has-courses/" + studentHasCourseSaved.getId()))
                .body(studentHasCourseSaved);
    }

    @PutMapping({"/{id}", "/{id}/"})
    // localhost:8080/students-has-courses/1 y localhost:8080/students-has-courses/1/ [PUT]
    public ResponseEntity updateStudentHasCourseById(@Valid @RequestBody StudentHasCourseDTO studentHasCourseDTO, @PathVariable Long id) {
        StudentHasCourseDTO studentHasCourseUpdate = studentHasCourseServices.updateStudentHasCourse(studentHasCourseDTO, id);
        return ResponseEntity.ok(studentHasCourseUpdate);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    // localhost:8080/students-has-courses/1 y localhost:8080/students-has-courses/1/ [DELETE]
    public ResponseEntity deleteStudentHasCourse(@PathVariable Long id) {
        studentHasCourseServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

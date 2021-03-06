package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.service.StudentServices;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    @Qualifier("studentServices")
    private StudentServices studentServices;

    @GetMapping({"", "/"}) // localhost:8080/students y localhost:8080/students/ [GET]
    public ResponseEntity getAllStudents() {
        List<StudentDTO> all = studentServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"}) // localhost:8080/students/1 y localhost:8080/students/1/ [GET]
    public ResponseEntity getStudentById(@PathVariable Long id) {
        StudentDTO studentById = studentServices.findStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping({"", "/"}) // localhost:8080/students y localhost:8080/students/ [POST]
    public ResponseEntity addNewStudent(@Valid @RequestBody StudentDTO studentDTO) throws URISyntaxException {
        StudentDTO studentSaved = studentServices.save(studentDTO);
        return ResponseEntity
                .created(new URI("/students/" + studentSaved.getId()))
                .body(studentSaved);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @DeleteMapping({"/{id}", "/{id}/"}) // localhost:8080/students/1 y localhost:8080/students/1/ [DELETE]
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

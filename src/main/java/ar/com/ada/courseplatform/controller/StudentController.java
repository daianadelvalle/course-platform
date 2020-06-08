package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    @Qualifier("studentServices")
    private StudentServices studentServices;

    @PostMapping({"", "/"}) // localhost:8080/students y localhost:8080/students/ [POST]
    public ResponseEntity addNewStudent(@Valid @RequestBody StudentDTO studentDTO) throws URISyntaxException {
        StudentDTO studentSaved = studentServices.save(studentDTO);
        return ResponseEntity
                .created(new URI("/students/" + studentSaved.getId()))
                .body(studentSaved);
    }
}

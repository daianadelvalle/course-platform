package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.service.CourseServices;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    @Qualifier("courseServices")
    private CourseServices courseServices;

    @PostMapping({"", "/"}) // localhost:8080/courses y localhost:8080/courses/
    public ResponseEntity addNewCourse(@Valid @RequestBody CourseDTO courseDTO) throws URISyntaxException {
        CourseDTO courseSaved = courseServices.save(courseDTO);
        return ResponseEntity
                .created(new URI("/courses/" + courseDTO.getId()))
                .body(courseSaved);
    }
}

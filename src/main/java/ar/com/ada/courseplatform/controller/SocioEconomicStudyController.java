package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.service.SocioEconomicStudyServices;
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
@RequestMapping("/socio-economic-studies")
public class SocioEconomicStudyController {

    @Autowired
    @Qualifier("socioEconomicStudyServices")
    private SocioEconomicStudyServices socioEconomicStudyServices;

    @GetMapping({"", "/"}) // localhost:8080/socio-economic-study y localhost:8080/socio-economic-study/ [GET]
    public ResponseEntity getAllSocioEconomicStudy() {
        List<SocioEconomicStudyDTO> all = socioEconomicStudyServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"})
    // localhost:8080/socio-economic-study/1 y localhost:8080/socio-economic-study/1/ [GET]
    public ResponseEntity getSocioEconomicStudyById(@PathVariable Long id) {
        SocioEconomicStudyDTO socioEconomicStudyById = socioEconomicStudyServices.findStudyById(id);
        return ResponseEntity.ok(socioEconomicStudyById);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping({"", "/"}) // localhost:8080/socio-economic-studies y localhost:8080/socio-economic-studies/ [POST]
    public ResponseEntity addNewSocioEconomicStudy(@Valid @RequestBody SocioEconomicStudyDTO socioEconomicStudyDTO) throws URISyntaxException {
        SocioEconomicStudyDTO socioEconomicStudySaved = socioEconomicStudyServices.save(socioEconomicStudyDTO);
        return ResponseEntity
                .created(new URI("/socio-economic-studies/" + socioEconomicStudySaved.getId()))
                .body(socioEconomicStudySaved);
    }

    // localhost:8080/companies/1/managers/1 y localhost:8080/companies/1/managers/1/ [PUT]
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping({"/{socio_economic_study_id}/students/{student_id}", "/{socio_economic_study_id}/students/{student_id}"})
    public ResponseEntity addStudentToStudy(@PathVariable Long socio_economic_study_id, @PathVariable Long student_id) {
        SocioEconomicStudyDTO studyDTOWithNewStudent = socioEconomicStudyServices.addStudentToStudy(socio_economic_study_id, student_id);
        return ResponseEntity.ok(studyDTOWithNewStudent);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @DeleteMapping({"/{id}", "/{id}/"})
    // localhost:8080/socio-economic-study/1 y localhost:8080/socio-economic-study/1/ [DELETE]
    public ResponseEntity deleteSocioEconomicStudy(@PathVariable Long id) {
        socioEconomicStudyServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

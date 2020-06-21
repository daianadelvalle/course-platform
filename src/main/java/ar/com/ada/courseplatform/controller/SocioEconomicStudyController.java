package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.service.SocioEconomicStudyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/socio-economic-studies")
public class SocioEconomicStudyController {

    @Autowired
    @Qualifier("socioEconomicStudyServices")
    private SocioEconomicStudyServices socioEconomicStudyServices;

    @PostMapping({"", "/"}) // localhost:8080/socio-economic-studies y localhost:8080/socio-economic-studies/ [POST]
    public ResponseEntity addNewSocioEconomicStudy(@Valid @RequestBody SocioEconomicStudyDTO socioEconomicStudyDTO) throws URISyntaxException {
        SocioEconomicStudyDTO socioEconomicStudySaved = socioEconomicStudyServices.save(socioEconomicStudyDTO);
        return ResponseEntity
                .created(new URI("/socio-economic-studies/" + socioEconomicStudySaved.getId()))
                .body(socioEconomicStudySaved);
    }

    // localhost:8080/companies/1/managers/1 y localhost:8080/companies/1/managers/1/ [PUT]
    @PutMapping({"/{socio_economic_study_id}/students/{student_id}", "/{socio_economic_study_id}/students/{student_id}"})
    public ResponseEntity addStudentToStudy(@PathVariable Long socio_economic_study_id, @PathVariable Long student_id) {
        SocioEconomicStudyDTO studyDTOWithNewStudent = socioEconomicStudyServices.addStudentToStudy(socio_economic_study_id, student_id);
        return ResponseEntity.ok(studyDTOWithNewStudent);
    }
}

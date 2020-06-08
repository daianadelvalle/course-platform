package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.service.SocioEconomicStudyServices;
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
}

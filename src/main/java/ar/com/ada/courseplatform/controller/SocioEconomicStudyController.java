package ar.com.ada.courseplatform.controller;

//import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
//import ar.com.ada.courseplatform.service.SocioEconomicStudyServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/socio-economic-study") //socio
//public class SocioEconomicStudyController {
//
//    @Autowired @Qualifier("socioEconomicStudyServices")
//    private SocioEconomicStudyServices socioEconomicStudyServices;
//
//    @GetMapping({ "", "/" }) // localhost:8080/socio-economic-study y localhost:8080/socio-economic-study/ [GET]
//    public ResponseEntity getAllSocioEconomicStudy() {
//        List<SocioEconomicStudyDTO> all = socioEconomicStudyServices.findAll();
//        return ResponseEntity.ok(all);
//    }
//
//    @GetMapping({ "/{id}", "/{id}/" }) // localhost:8080/socio-economic-study/1 y localhost:8080/socio-economic-study/1/ [GET]
//    public ResponseEntity getSocioEconomicStudyById(@PathVariable Long id) {
//        SocioEconomicStudyDTO socioEconomicStudyById = socioEconomicStudyServices.findSocioEconomicStudyById(id);
//        return ResponseEntity.ok(socioEconomicStudyById);
//    }
//
//    @PostMapping({ "", "/" }) // localhost:8080/socio-economic-study y localhost:8080/socio-economic-study/ [POST]
//    public ResponseEntity addNewSocioEconomicStudy(@Valid @RequestBody SocioEconomicStudyDTO socioEconomicStudyDTO) throws URISyntaxException {
//        SocioEconomicStudyDTO socioEconomicStudySaved = socioEconomicStudyServices.save(socioEconomicStudyDTO);
//        return ResponseEntity
//                .created(new URI("/socio-economic-study/" + socioEconomicStudySaved.getId()))
//                .body(socioEconomicStudySaved);
//    }
//
//    @PutMapping({ "/{id}", "/{id}/" }) // localhost:8080/socio-economic-study/1 y localhost:8080/socio-economic-study/1/ [PUT]
//    public ResponseEntity updateSocioEconomicStudyById(@Valid @RequestBody SocioEconomicStudyDTO socioEconomicStudyDTO, @PathVariable Long id) {
//        SocioEconomicStudyDTO socioEconomicStudyUpdate = socioEconomicStudyServices.updateSocioEconomicStudy(socioEconomicStudyDTO, id);
//        return ResponseEntity.ok(socioEconomicStudyUpdate);
//    }
//
//    @DeleteMapping({ "/{id}", "/{id}/" }) // localhost:8080/socio-economic-study/1 y localhost:8080/socio-economic-study/1/ [DELETE]
//    public ResponseEntity deleteSocioEconomicStudy(@PathVariable Long id) {
//        socioEconomicStudyServices.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}

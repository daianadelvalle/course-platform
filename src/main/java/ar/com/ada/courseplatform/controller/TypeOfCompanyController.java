package ar.com.ada.courseplatform.controller;

//import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
//import ar.com.ada.courseplatform.service.TypeOfCompanyServices;
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
//@RequestMapping("/type-of-companies")
//public class TypeOfCompanyController {
//
//    @Autowired
//    @Qualifier("managerServices")
//    private TypeOfCompanyServices typeOfCompanyServices;
//
//    @GetMapping({"", "/"}) // localhost:8080/type-of-companies y localhost:8080/type-of-companies/ [GET]
//    public ResponseEntity getAllTypeOfCompany() {
//        List<TypeOfCompanyDTO> all = typeOfCompanyServices.findAll();
//        return ResponseEntity.ok(all);
//    }
//
//    @GetMapping({"/{id}", "/{id}/"}) // localhost:8080/type-of-companies/1 y localhost:8080/type-of-companies/1/ [GET]
//    public ResponseEntity getTypeOfCompanyById(@PathVariable Long id) {
//        TypeOfCompanyDTO typeOfCompanyById = typeOfCompanyServices.findTypeOfCompanyById(id);
//        return ResponseEntity.ok(typeOfCompanyById);
//    }
//
//    @PostMapping({"", "/"}) // localhost:8080/type-of-companies y localhost:8080/type-of-companies/ [POST]
//    public ResponseEntity addNewTypeOfCompany(@Valid @RequestBody TypeOfCompanyDTO typeOfCompanyDTO) throws URISyntaxException {
//        TypeOfCompanyDTO typeOfCompanySaved = typeOfCompanyServices.save(typeOfCompanyDTO);
//        return ResponseEntity
//                .created(new URI("/managers/" + typeOfCompanySaved.getId()))
//                .body(typeOfCompanySaved);
//    }
//
//    @PutMapping({"/{id}", "/{id}/"}) // localhost:8080/type-of-companies/1 y localhost:8080/type-of-companies/1/ [PUT]
//    public ResponseEntity updateTypeOfCompanyById(@Valid @RequestBody TypeOfCompanyDTO typeOfCompanyDTO, @PathVariable Long id) {
//        TypeOfCompanyDTO typeOfCompanyUpdate = typeOfCompanyServices.updateTypeOfCompany(typeOfCompanyDTO, id);
//        return ResponseEntity.ok(typeOfCompanyUpdate);
//    }
//
//    @DeleteMapping({"/{id}", "/{id}/"})
//    // localhost:8080/type-of-companies/1 y localhost:8080/type-of-companies/1/ [DELETE]
//    public ResponseEntity deleteTypeOfCompany(@PathVariable Long id) {
//        typeOfCompanyServices.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}

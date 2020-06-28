package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.service.TypeOfCompanyServices;
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
@RequestMapping("/type-of-companies")
public class TypeOfCompanyController {

    @Autowired
    @Qualifier("typeOfCompanyServices")
    private TypeOfCompanyServices typeOfCompanyServices;

    @GetMapping({"", "/"}) // localhost:8080/type-of-companies y localhost:8080/type-of-companies/ [GET]
    public ResponseEntity getAllTypeOfCompany() {
        List<TypeOfCompanyDTO> all = typeOfCompanyServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"}) // localhost:8080/type-of-companies/1 y localhost:8080/type-of-companies/1/ [GET]
    public ResponseEntity getTypeOfCompanyById(@PathVariable Long id) {
        TypeOfCompanyDTO typeOfCompanyById = typeOfCompanyServices.findTypeOfCompanyById(id);
        return ResponseEntity.ok(typeOfCompanyById);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping({"", "/"}) // localhost:8080/type-of-companies y localhost:8080/type-of-companies/ [POST]
    public ResponseEntity addNewTypeOfCompany(@Valid @RequestBody TypeOfCompanyDTO typeOfCompanyDTO) throws URISyntaxException {
        TypeOfCompanyDTO typeOfCompanySaved = typeOfCompanyServices.save(typeOfCompanyDTO);
        return ResponseEntity
                .created(new URI("/type-of-companies/" + typeOfCompanySaved.getId()))
                .body(typeOfCompanySaved);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping({"/{id}", "/{id}/"})
    // localhost:8080/type-of-companies/1 y localhost:8080/type-of-companies/1/ [DELETE]
    public ResponseEntity deleteTypeOfCompany(@PathVariable Long id) {
        typeOfCompanyServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

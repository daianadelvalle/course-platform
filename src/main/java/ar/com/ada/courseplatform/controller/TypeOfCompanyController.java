package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.service.security.TypeOfCompanyServices;
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
@RequestMapping("/type-of-companies")
public class TypeOfCompanyController {

    @Autowired
    @Qualifier("typeOfCompanyServices")
    private TypeOfCompanyServices typeOfCompanyServices;

    @PostMapping({"", "/"}) // localhost:8080/type-of-companies y localhost:8080/type-of-companies/ [POST]
    public ResponseEntity addNewTypeOfCompany(@Valid @RequestBody TypeOfCompanyDTO typeOfCompanyDTO) throws URISyntaxException {
        TypeOfCompanyDTO typeOfCompanySaved = typeOfCompanyServices.save(typeOfCompanyDTO);
        return ResponseEntity
                .created(new URI("/type-of-companies/" + typeOfCompanySaved.getId()))
                .body(typeOfCompanySaved);
    }
}

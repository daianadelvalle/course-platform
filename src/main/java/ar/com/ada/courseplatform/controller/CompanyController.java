package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.service.security.CompanyServices;
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
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    @Qualifier("companyServices")
    private CompanyServices companyService;

    @PostMapping({ "", "/" }) // localhost:8080/companies y localhost:8080/companies/
    public ResponseEntity addNewCompany(@Valid @RequestBody CompanyDTO companyDTO) throws URISyntaxException {
        CompanyDTO companySaved = companyService.save(companyDTO);
        return ResponseEntity
                .created(new URI("/companies/" + companyDTO.getId()))
                .body(companySaved);
    }
}

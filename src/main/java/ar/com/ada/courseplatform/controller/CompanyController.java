package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.service.security.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    @Qualifier("companyServices")
    private CompanyServices companyService;

    @GetMapping({ "", "/" }) // localhost:8080/companies y localhost:8080/companies/ [GET]
    public ResponseEntity getAllCompanies() {
        List<CompanyDTO> all = companyService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({ "/{id}", "/{id}/" }) // localhost:8080/companies/1 y localhost:8080/companies/1/ [GET]
    public ResponseEntity getCompanyById(@PathVariable Long id) {
        CompanyDTO companyById = companyService.findCompanyById(id);
        return ResponseEntity.ok(companyById);
    }
    @PostMapping({ "", "/" }) // localhost:8080/companies y localhost:8080/companies/
    public ResponseEntity addNewCompany(@Valid @RequestBody CompanyDTO companyDTO) throws URISyntaxException {
        CompanyDTO companySaved = companyService.save(companyDTO);
        return ResponseEntity
                .created(new URI("/companies/" + companyDTO.getId()))
                .body(companySaved);
    }

    // localhost:8080/companies/1/managers/1 y localhost:8080/companies/1/managers/1/ [PUT]
    @PutMapping({"/{company_id}/managers/{manager_id}", "/{company_id}/managers/{manager_id}"})
    public ResponseEntity addManagerToCompany(@PathVariable Long company_id, @PathVariable Long manager_id) {
        CompanyDTO companyDTOWithNewManager = companyService.addManagerToCompany(manager_id, company_id);
        return ResponseEntity.ok(companyDTOWithNewManager);
    }
}

package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.service.CompanyServices;
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
public class CompanyController {

    @Autowired
    @Qualifier("companyServices")
    private CompanyServices companyService;


    @GetMapping({"/companies", "/companies/"}) // localhost:8080/companies y localhost:8080/companies/ [GET]
    public ResponseEntity getAllCompanies() {
        List<CompanyDTO> all = companyService.findAll();
        return ResponseEntity.ok(all);
    }
    // localhost:8080/companies/1 y localhost:8080/companies/1/ [GET]
    @GetMapping({"/companies/{id}", "/companies/{id}/"})
    public ResponseEntity getCompanyById(@PathVariable Long id) {
        CompanyDTO companyById = companyService.findCompanyById(id);
        return ResponseEntity.ok(companyById);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping({"/companies", "/companies/"}) // localhost:8080/companies y localhost:8080/companies/
    public ResponseEntity addNewCompany(@Valid @RequestBody CompanyDTO companyDTO) throws URISyntaxException {
        CompanyDTO companySaved = companyService.save(companyDTO);
        return ResponseEntity
                .created(new URI("/companies/" + companyDTO.getId()))
                .body(companySaved);
    }

    // localhost:8080/companies/managers y localhost:8080/companies/managers/ [GET]
    @GetMapping({"/managers", "/managers/"})
    public ResponseEntity getAllManagers() {
        List<ManagerDTO> all = companyService.findAllManagers();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/managers/{id}", "/managers/{id}/"}) // localhost:8080/managers/1 y localhost:8080/managers/1/ [GET]
    public ResponseEntity getManagerById(@PathVariable Long id) {
        ManagerDTO managerById = companyService.findManagerById(id);
        return ResponseEntity.ok(managerById);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping({"/managers", "/managers/"}) // localhost:8080/managers y localhost:8080/managers/
    public ResponseEntity addNewManager(@Valid @RequestBody ManagerDTO managerDTO) throws URISyntaxException {
        ManagerDTO managerSaved = companyService.save(managerDTO);
        return ResponseEntity
                .created(new URI("/managers/" + managerDTO.getId()))
                .body(managerSaved);
    }

    // localhost:8080/companies/1/managers/1 y localhost:8080/companies/1/managers/1/ [PUT]
    @PutMapping({"/{manager_id}/managers/{company_id}", "/{manager_id}/managers/{company_id}"})
    public ResponseEntity addManagerToCompany(@PathVariable Long manager_id, @PathVariable Long company_id) {
        ManagerDTO managerDTOWithNewCompany = companyService.addManagerToCompany(manager_id, company_id);
        return ResponseEntity.ok(managerDTOWithNewCompany);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping({"/companies/{id}", "/companies/{id}/"}) // localhost:8080/companies/1 y localhost:8080/companies/1/
    public ResponseEntity deleteCompany(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({"/managers/{id}", "/managers/{id}/"}) // localhost:8080/managers/1 y localhost:8080/managers/1/
    public ResponseEntity deleteManager(@PathVariable Long id) {
        companyService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}

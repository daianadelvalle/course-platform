package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.service.security.ManagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    @Qualifier("managerServices")
    private ManagerServices managerServices;

    @GetMapping({ "", "/" }) // localhost:8080/managers y localhost:8080/managers/ [GET]
    public ResponseEntity getAllManagers() {
        List<ManagerDTO> all = managerServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({ "/{id}", "/{id}/" }) // localhost:8080/managers/1 y localhost:8080/managers/1/ [GET]
    public ResponseEntity getManagerById(@PathVariable Long id) {
        ManagerDTO managerById = managerServices.findManagerById(id);
        return ResponseEntity.ok(managerById);
    }

    @PostMapping({"", "/"}) // localhost:8080/managers y localhost:8080/managers/
    public ResponseEntity addNewManager(@Valid @RequestBody ManagerDTO managerDTO) throws URISyntaxException {
        ManagerDTO managerSaved = managerServices.save(managerDTO);
        return ResponseEntity
                .created(new URI("/managers/" + managerDTO.getId()))
                .body(managerSaved);
    }
}

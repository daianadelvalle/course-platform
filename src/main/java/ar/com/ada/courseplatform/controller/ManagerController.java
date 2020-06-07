package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.service.security.ManagerServices;
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
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    @Qualifier("managerServices")
    private ManagerServices managerServices;

    @PostMapping({"", "/"}) // localhost:8080/managers y localhost:8080/managers/
    public ResponseEntity addNewManager(@Valid @RequestBody ManagerDTO managerDTO) throws URISyntaxException {
        ManagerDTO managerSaved = managerServices.save(managerDTO);
        return ResponseEntity
                .created(new URI("/companies/" + managerDTO.getId()))
                .body(managerSaved);
    }
}

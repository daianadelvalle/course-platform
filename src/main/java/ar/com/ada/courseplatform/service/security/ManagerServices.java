package ar.com.ada.courseplatform.service.security;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Manager;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.ManagerMapper;
import ar.com.ada.courseplatform.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("managerServices")
public class ManagerServices implements Services<ManagerDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("managerRepository")
    private ManagerRepository managerRepository;

    private final ManagerMapper managerMapper = ManagerMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<ManagerDTO> findAll() {
        List<Manager> all = managerRepository.findAll();
        List<ManagerDTO> managerDTOList = managerMapper.toDto(all, context);
        return managerDTOList;
    }

    public ManagerDTO findManagerById(Long id) {
        Optional<Manager> byIdOptional = managerRepository.findById(id);
        ManagerDTO managerDTO = null;

        if (byIdOptional.isPresent()) {
            Manager manager = byIdOptional.get();
            managerDTO = managerMapper.toDto(manager, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Manager", id);
        }

        return managerDTO;
    }


    @Override
    public ManagerDTO save(ManagerDTO dto) {
        Manager managerToSave = managerMapper.toEntity(dto, context);
        Manager managerSaved = managerRepository.save(managerToSave);
        ManagerDTO managerDTOtoSaved = managerMapper.toDto(managerSaved, context);
        return managerDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }

    public ManagerDTO updateManager(ManagerDTO managerDTO, Long id) {
        return null;
    }
}

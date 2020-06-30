package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.TypeOfCompanyMapper;
import ar.com.ada.courseplatform.model.repository.TypeOfCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("typeOfCompanyServices")
public class TypeOfCompanyServices implements Services<TypeOfCompanyDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    private TypeOfCompanyMapper typeOfCompanyMapper = TypeOfCompanyMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<TypeOfCompanyDTO> findAll() {
        List<TypeOfCompany> all = typeOfCompanyRepository.findAll();
        List<TypeOfCompanyDTO> typeOfCompanyDTOS = typeOfCompanyMapper.toDto(all, context);
        return typeOfCompanyDTOS;
    }

    public TypeOfCompanyDTO findTypeOfCompanyById(Long id) {
        TypeOfCompany typeOfCompany = typeOfCompanyRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Type Of Company", id));
        TypeOfCompanyDTO typeOfCompanyDTO = typeOfCompanyMapper.toDto(typeOfCompany, context);
        return typeOfCompanyDTO;
    }

    @Override
    public TypeOfCompanyDTO save(TypeOfCompanyDTO dto) {
        TypeOfCompany typeOfCompanyToSave = typeOfCompanyMapper.toEntity(dto, context);
        TypeOfCompany typeOfCompanySaved = typeOfCompanyRepository.save(typeOfCompanyToSave);
        TypeOfCompanyDTO typeOfCompanyDTOSaved = typeOfCompanyMapper.toDto( typeOfCompanySaved, context);
        return typeOfCompanyDTOSaved;
    }

    @Override
    public void delete(Long id) {
        Optional<TypeOfCompany> byIdOptional = typeOfCompanyRepository.findById(id);

        if (byIdOptional.isPresent()) {
            TypeOfCompany typeOfCompanyToDelete = byIdOptional.get();
            typeOfCompanyRepository.delete(typeOfCompanyToDelete);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Type Of Company", id);
        }
    }
}

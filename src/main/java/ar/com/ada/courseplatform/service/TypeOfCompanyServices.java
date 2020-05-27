package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.TypeOfCompanyDTO;
import ar.com.ada.courseplatform.model.repository.TypeOfCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class TypeOfCompanyServices implements Services<TypeOfCompanyDTO> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    private TypeOfCompanyCycleMapper typeOfCompanyCycleMapper = TypeOfCompanyCycleMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<TypeOfCompanyDTO> findAll() {
        return null;
    }

    @Override
    public TypeOfCompanyDTO save(TypeOfCompanyDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

package ar.com.ada.courseplatform.service.security;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.exception.ApiEntityError;
import ar.com.ada.courseplatform.exception.BusinessLogicException;
import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.entity.Manager;
import ar.com.ada.courseplatform.model.mapper.CompanyMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
import ar.com.ada.courseplatform.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyServices")
public class CompanyServices implements Services<CompanyDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier("managerRepository")
    private ManagerRepository managerRepository;

    private final CompanyMapper companyMapper = CompanyMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<CompanyDTO> findAll() {
        List<Company> all = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = companyMapper.toDto(all, context);
        return companyDTOList;
    }

    public CompanyDTO findCompanyById(Long id) {
        Optional<Company> byIdOptional = companyRepository.findById(id);
        CompanyDTO companyDTO = null;

        if (byIdOptional.isPresent()) {
            Company company = byIdOptional.get();
            companyDTO = companyMapper.toDto(company, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Company", id);
        }

        return companyDTO;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        Company companyToSave = companyMapper.toEntity(dto, context);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDTO companyDTOtoSaved = companyMapper.toDto(companySaved, context);
        return companyDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }

    public CompanyDTO addManagerToCompany(Long manager_id, Long company_id) {
        Optional<Company> companyByIdOptional = companyRepository.findById(company_id);
        Optional<Manager> managerByIdOptional = managerRepository.findById(manager_id);
        CompanyDTO companyDTOWithNewManager = null;

        if (!companyByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Company", company_id);

        if (!managerByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Manager", manager_id);

        Company company = companyByIdOptional.get();
        Manager managerToAdd = managerByIdOptional.get();

        boolean hasManagerInCompany = company.getManager() == null;

        if (hasManagerInCompany) {
            company.addManager(managerToAdd);
            Company companyWithNewManager = companyRepository.save(company);
            companyDTOWithNewManager = companyMapper.toDto(companyWithNewManager, context);
        } else {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Manager",
                    "AlreadyExist",
                    "This company already has a manager"
            );
            throw new BusinessLogicException(
                    "Manager already exist in the company",
                    HttpStatus.BAD_REQUEST,
                    apiEntityError
            );
        }
        return companyDTOWithNewManager;

    }
}

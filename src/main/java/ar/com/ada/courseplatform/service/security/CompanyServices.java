package ar.com.ada.courseplatform.service.security;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.exception.ApiEntityError;
import ar.com.ada.courseplatform.exception.BusinessLogicException;
import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.entity.Manager;
import ar.com.ada.courseplatform.model.mapper.CompanyMapper;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.ManagerMapper;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
import ar.com.ada.courseplatform.model.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyServices")
public class CompanyServices  {

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
    private final ManagerMapper managerMapper = ManagerMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;



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


    public CompanyDTO save(CompanyDTO dto) {
        Company companyToSave = companyMapper.toEntity(dto, context);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDTO companyDTOtoSaved = companyMapper.toDto(companySaved, context);
        return companyDTOtoSaved;
    }


    public void delete(Long id) {

    }


    /*
    # -------------------------------------------------------- #
                     MANAGER
    # -------------------------------------------------------- #
    */


    public List<ManagerDTO> findAllManagers() {
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

    public ManagerDTO save(ManagerDTO dto) {
        Manager managerToSave = managerMapper.toEntity(dto, context);
        Manager managerSaved = managerRepository.save(managerToSave);
        ManagerDTO managerDTOtoSaved = managerMapper.toDto(managerSaved, context);
        return managerDTOtoSaved;
    }


    public void deleteManager(Long id) {

    }

    public ManagerDTO updateManager(ManagerDTO managerDTO, Long id) {
        return null;
    }

    public ManagerDTO addManagerToCompany(Long company_id, Long manager_id) {
        Optional<Company> companyByIdOptional = companyRepository.findById(company_id);
        Optional<Manager> managerByIdOptional = managerRepository.findById(manager_id);
        ManagerDTO managerDTOWithNewCompany = null;

        if (!companyByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Company", company_id);

        if (!managerByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Manager", manager_id);

        Manager manager = managerByIdOptional.get();
        Company companyToAdd = companyByIdOptional.get();

        boolean hasManagerInCompany = manager.getCompany() == null;

        if (hasManagerInCompany) {
            manager.addCompany(companyToAdd);
            Manager managerWithNewCompany = managerRepository.save(manager);
            managerDTOWithNewCompany = managerMapper.toDto(managerWithNewCompany, context);
        } else {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Company",
                    "AlreadyExist",
                    "This manager already has a company"
            );
            throw new BusinessLogicException(
                    "Manager already exist in the company",
                    HttpStatus.BAD_REQUEST,
                    apiEntityError
            );
        }
        return managerDTOWithNewCompany;
    }
}

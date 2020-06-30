package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.exception.ApiEntityError;
import ar.com.ada.courseplatform.exception.BusinessLogicException;
import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import ar.com.ada.courseplatform.model.entity.Student;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.SocioEconomicStudyMapper;
import ar.com.ada.courseplatform.model.repository.SocioEconomicStudyRepository;
import ar.com.ada.courseplatform.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("socioEconomicStudyServices")
public class SocioEconomicStudyServices implements Services<SocioEconomicStudyDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("socioEconomicStudyRepository")
    private SocioEconomicStudyRepository socioEconomicStudyRepository;


    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    private final SocioEconomicStudyMapper socioEconomicStudyMapper = SocioEconomicStudyMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<SocioEconomicStudyDTO> findAll() {
        List<SocioEconomicStudy> all = socioEconomicStudyRepository.findAll();
        List<SocioEconomicStudyDTO> socioEconomicStudyDTOList = socioEconomicStudyMapper.toDto(all, context);
        return socioEconomicStudyDTOList;
    }

    public SocioEconomicStudyDTO findStudyById(Long id) {
        SocioEconomicStudy socioEconomicStudy = socioEconomicStudyRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("SocioEconomicStudy", id));
        SocioEconomicStudyDTO courseDTO = socioEconomicStudyMapper.toDto(socioEconomicStudy, context);
        return courseDTO;
    }

    @Override
    public SocioEconomicStudyDTO save(SocioEconomicStudyDTO dto) {
        Long studentId = dto.getStudentId();
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Student", studentId));
        SocioEconomicStudy socioEconomicStudyToSave = socioEconomicStudyMapper.toEntity(dto, context);
        socioEconomicStudyToSave.setStudent(student);
        SocioEconomicStudy socioEconomicStudySaved = socioEconomicStudyRepository.save(socioEconomicStudyToSave);
        SocioEconomicStudyDTO socioEconomicStudyDTOtoSaved = socioEconomicStudyMapper.toDto(socioEconomicStudySaved, context);

        return socioEconomicStudyDTOtoSaved;
    }

    @Override
    public void delete(Long id) {
        Optional<SocioEconomicStudy> byIdOptional = socioEconomicStudyRepository.findById(id);

        if (byIdOptional.isPresent()) {
            SocioEconomicStudy socioEconomicStudyToDelete = byIdOptional.get();
            socioEconomicStudyRepository.delete(socioEconomicStudyToDelete);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Socio Economic Study", id);
        }
    }

    public SocioEconomicStudyDTO addStudentToStudy(Long student_id, Long socio_economic_study_id) {
        Optional<Student> studentByIdOptional = studentRepository.findById(student_id);
        Optional<SocioEconomicStudy> studyByIdOptional = socioEconomicStudyRepository.findById(socio_economic_study_id);
        SocioEconomicStudyDTO studyDTOWithNewStudent = null;

        if (!studentByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Student", student_id);

        if (!studyByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("SocioEconomicStudy", socio_economic_study_id);

        SocioEconomicStudy socioEconomicStudy = studyByIdOptional.get();
        Student studentToAdd = studentByIdOptional.get();

        boolean hasStudentInStudy = socioEconomicStudy.getStudent() == null;

        if (hasStudentInStudy) {
            socioEconomicStudy.addStudent(studentToAdd);
            SocioEconomicStudy studyWithNewStudent = socioEconomicStudyRepository.save(socioEconomicStudy);
            studyDTOWithNewStudent = socioEconomicStudyMapper.toDto(studyWithNewStudent, context);
        } else {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Student",
                    "AlreadyExist",
                    "This study already has a student"
            );
            throw new BusinessLogicException(
                    "Socio-economic-study already exist in the student",
                    HttpStatus.BAD_REQUEST,
                    apiEntityError
            );
        }
        return studyDTOWithNewStudent;
    }
}

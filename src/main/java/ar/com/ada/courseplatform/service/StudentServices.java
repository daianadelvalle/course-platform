package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.model.entity.Student;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.StudentMapper;
import ar.com.ada.courseplatform.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServices")
public class StudentServices implements Services<StudentDTO> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    private StudentMapper studentMapper = StudentMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;


    @Override
    public List<StudentDTO> findAll() {
        return null;
    }

    @Override
    public StudentDTO save(StudentDTO dto) {
        Student studentToSave = studentMapper.toEntity(dto, context);
        Student studentSaved = studentRepository.save(studentToSave);
        StudentDTO studentDTOtoSaved = studentMapper.toDto(studentSaved, context);
        return studentDTOtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}

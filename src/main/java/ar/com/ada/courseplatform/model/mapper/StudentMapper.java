package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.model.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface StudentMapper extends CycleDataMapper<StudentDTO, Student> {

    @Override
    Student toEntity(StudentDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<Student> toEntity(List<StudentDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    StudentDTO toDto(Student entity, CycleAvoidingMappingContext context);

    @Override
    List<StudentDTO> toDto(List<Student> entityList, CycleAvoidingMappingContext context);
}

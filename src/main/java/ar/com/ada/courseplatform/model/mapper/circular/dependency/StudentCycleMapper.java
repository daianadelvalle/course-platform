package ar.com.ada.courseplatform.model.mapper.circular.dependency;

import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentCycleMapper extends DataCycleMapper<StudentDTO, Student> {
    StudentCycleMapper MAPPER = Mappers.getMapper(StudentCycleMapper.class);
}

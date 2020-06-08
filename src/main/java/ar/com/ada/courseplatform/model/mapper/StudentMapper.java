package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.StudentDTO;
import ar.com.ada.courseplatform.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper extends CycleDataMapper<StudentDTO, Student>{
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);
}

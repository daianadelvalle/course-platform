package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface StudentHasCourseMapper extends CycleDataMapper<StudentHasCourseDTO, StudentHasCourse>{

    @Override
    StudentHasCourse toEntity(StudentHasCourseDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<StudentHasCourse> toEntity(List<StudentHasCourseDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    StudentHasCourseDTO toDto(StudentHasCourse entity, CycleAvoidingMappingContext context);

    @Override
    List<StudentHasCourseDTO> toDto(List<StudentHasCourse> entityList, CycleAvoidingMappingContext context);
}

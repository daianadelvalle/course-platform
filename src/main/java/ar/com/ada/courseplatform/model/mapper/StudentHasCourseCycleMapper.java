package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentHasCourseCycleMapper extends CycleDataMapper<StudentHasCourseDTO, StudentHasCourse> {
    StudentHasCourseCycleMapper MAPPER = Mappers.getMapper(StudentHasCourseCycleMapper.class);
}

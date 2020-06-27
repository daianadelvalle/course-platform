package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentHasCourseMapper extends CycleDataMapper<StudentHasCourseDTO, StudentHasCourse> {

    StudentHasCourseMapper MAPPER = Mappers.getMapper(StudentHasCourseMapper.class);

}

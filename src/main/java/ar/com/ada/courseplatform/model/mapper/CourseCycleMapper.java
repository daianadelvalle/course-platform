package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseCycleMapper extends CycleDataMapper<CourseDTO, Course> {
    CourseCycleMapper MAPPER = Mappers.getMapper(CourseCycleMapper.class);
}

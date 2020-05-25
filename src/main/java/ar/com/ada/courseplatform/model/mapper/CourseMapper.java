package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper extends CycleDataMapper<CourseDTO, Course> {

    @Override
    Course toEntity(CourseDTO dto, CycleAvoidingMappingContext context);

    @Override
    List<Course> toEntity(List<CourseDTO> dtoList, CycleAvoidingMappingContext context);

    @Override
    CourseDTO toDto(Course entity, CycleAvoidingMappingContext context);

    @Override
    List<CourseDTO> toDto(List<Course> entityList, CycleAvoidingMappingContext context);
}

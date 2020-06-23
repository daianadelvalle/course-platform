package ar.com.ada.courseplatform.model.mapper;

import ar.com.ada.courseplatform.model.dto.CourseDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.entity.Course;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper extends CycleDataMapper<CourseDTO, Course> {
    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "companyId", ignore = true)
    CourseDTO toDto(Company entity, @Context CycleAvoidingMappingContext context);
}

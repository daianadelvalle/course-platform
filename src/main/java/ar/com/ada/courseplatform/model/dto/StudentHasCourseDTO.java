package ar.com.ada.courseplatform.model.dto;

import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.entity.Student;
import ar.com.ada.courseplatform.model.entity.StudentHasCourseId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "student_id", "course_id", "direct_award", "approval_status", "finalized"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentHasCourseDTO {

    private StudentHasCourseId id;

    @JsonIgnoreProperties({"studentHasCourses"})
    private Student student;

    @JsonIgnoreProperties({"studentHasCourses"})
    private Course course;

    //tipo de solicitud del curso: directa o beca
    private Boolean directAward;

    //aprobada o desaprovada la solicitud de cupo
    private Boolean approvalStatus;

    //finalizado o no finalizado el curso
    private Boolean finalized;
}

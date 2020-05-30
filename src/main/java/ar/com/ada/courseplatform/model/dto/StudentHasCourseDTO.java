package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"student", "course", "type_of_request", "approbal_status", "finalizaded"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentHasCourseDTO implements Serializable {

    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    //tipo de solicitud del curso: directa o beca
    private String typeOfRequest;

    //aprobada o desaprovada la solicitud
    private Boolean approvalStatus;

    //finalizado o no finalizado el curso
    private Boolean finalized;

    public StudentHasCourseDTO(String typeOfRequest, Boolean approvalStatus, Boolean finalized) {
        this.typeOfRequest = typeOfRequest;
        this.approvalStatus = approvalStatus;
        this.finalized = finalized;
    }

}

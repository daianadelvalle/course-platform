package ar.com.ada.courseplatform.model.dto;

import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "description", "modality", "cost", "workload", "category",
        "quota", "scolarship", "direct_award", "scolarship_accountant", "available", "student_has_courses"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseDTO implements Serializable {

    //attr

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "modality is required")
    private String modality;

    @NotNull(message = "cost is required")
    @Positive(message = "only positive values")
    private Double cost;

    //carga horaria
    @NotNull(message = "workload is required")
    @Positive(message = "only positive values")
    private Integer workload;

    @NotBlank(message = "category is required")
    private String category;

    //cupos
    @NotNull(message = "quota is required")
    @Positive(message = "only positive values")
    private Integer quota;

    //cantidad de becas
    @NotNull(message = "scolarship is required")
    @Positive(message = "only positive values")
    private Integer scolarship;

    //adjudicación directa se seteara con la cantidad de cupos menos becas
    @NotNull(message = "direct Award is required")
    private Integer directAward;

    //contador de becas
    @NotNull(message = "scolarship Accountant is required")
    private Integer scolarshipAccountant;

    @NotNull(message = "company_id is required")
    private Long companyId;

    //se inicializa a true hasta que no hay màs cupos disponibles
    private Boolean available;

    //relationship
    private CompanyDTO company;

    @JsonIgnoreProperties({ "student", "course"})
    private Set<StudentHasCourse> studentHasCourses;

}

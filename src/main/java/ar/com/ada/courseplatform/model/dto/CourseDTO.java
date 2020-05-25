package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "description", "modality", "cost", "workload", "category",
        "quota", "scolarship", "directAward", "scolarshipAccountant", "",})
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

    //adjudicación directa inicializado a 0
    @NotNull(message = "direct Award is required")
    private Integer directAward;

    //contador de becas
    @NotNull(message = "scolarship Accountant is required")
    private Integer scolarshipAccountant;

    //relationship
    private Set<CompanyDTO> company;

    public CourseDTO(Long id, String name, String description, String modality, Double cost,
                     Integer workload, String category, Integer quota, Integer scolarship,
                     Integer directAward, Integer scolarshipAccountant, Set<CompanyDTO> company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modality = modality;
        this.cost = cost;
        this.workload = workload;
        this.category = category;
        this.quota = quota;
        this.scolarship = scolarship;
        this.directAward = directAward;
        this.scolarshipAccountant = scolarshipAccountant;
        this.company = company;
    }

    public CourseDTO(String name, String description, String modality, Double cost,
                     Integer workload, String category, Integer quota, Integer scolarship,
                     Integer directAward, Integer scolarshipAccountant, Set<CompanyDTO> company) {
        this.name = name;
        this.description = description;
        this.modality = modality;
        this.cost = cost;
        this.workload = workload;
        this.category = category;
        this.quota = quota;
        this.scolarship = scolarship;
        this.directAward = directAward;
        this.scolarshipAccountant = scolarshipAccountant;
        this.company = company;
    }
}

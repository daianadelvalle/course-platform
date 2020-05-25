package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "study", "work", "incomes", "amountOfIncomes", "familyInCharge", "numbersOfFamilyInCharge"})
public class SocioEconomicStudyDTO  implements Serializable {

    //attr
    private Long id;


    private Boolean study;

    private Boolean work;

    private Boolean incomes;

    private Double amountOfIncomes;
    private Boolean familyInCharge;

    @PositiveOrZero
    private Integer numbersOfFamilyInCharge;

    //relationship
    private Set<StudentDTO> student;

    public SocioEconomicStudyDTO(Long id, Boolean study, Boolean work, Boolean incomes, Double amountOfIncomes, Boolean familyInCharge, Integer numbersOfFamilyInCharge, Set<StudentDTO> student) {
        this.id = id;
        this.study = study;
        this.work = work;
        this.incomes = incomes;
        this.amountOfIncomes = amountOfIncomes;
        this.familyInCharge = familyInCharge;
        this.numbersOfFamilyInCharge = numbersOfFamilyInCharge;
        this.student = student;
    }

}

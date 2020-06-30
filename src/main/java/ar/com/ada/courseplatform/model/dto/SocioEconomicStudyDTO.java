package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "study", "work", "incomes", "amount_of_incomes", "family_in_charge", "numbers_of_family_in_charge"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SocioEconomicStudyDTO implements Serializable {
    //attr
    private Long id;

    //estudia o no
    private Boolean study;

    //trabaja o no
    private Boolean work;

    //tiene ingresos o no
    private Boolean incomes;

    // cantidad de ingresos
    private Double amountOfIncomes;

    // familia a cargo
    private Boolean familyInCharge;

    // cantidad de familiares a cargo
    @PositiveOrZero
    private Integer numbersOfFamilyInCharge;

    //relationship
    @JsonIgnoreProperties({"student"})
    private StudentDTO studentDTO;

    @NotNull(message = "student_Id is required")
    private Long studentId;

    //setters
    public SocioEconomicStudyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public SocioEconomicStudyDTO setStudy(Boolean study) {
        this.study = study;
        return this;
    }

    public SocioEconomicStudyDTO setWork(Boolean work) {
        this.work = work;
        return this;
    }

    public SocioEconomicStudyDTO setIncomes(Boolean incomes) {
        this.incomes = incomes;
        return this;
    }

    public SocioEconomicStudyDTO setAmountOfIncomes(Double amountOfIncomes) {
        this.amountOfIncomes = amountOfIncomes;
        return this;
    }

    public SocioEconomicStudyDTO setFamilyInCharge(Boolean familyInCharge) {
        this.familyInCharge = familyInCharge;
        return this;
    }

    public SocioEconomicStudyDTO setNumbersOfFamilyInCharge(Integer numbersOfFamilyInCharge) {
        this.numbersOfFamilyInCharge = numbersOfFamilyInCharge;
        return this;
    }

    public SocioEconomicStudyDTO setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }
}

package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    private Boolean study;

    private Boolean work;

    private Boolean incomes;

    private Double amountOfIncomes;

    private Boolean familyInCharge;

    @PositiveOrZero
    private Integer numbersOfFamilyInCharge;

    //relationship
    private StudentDTO studentDTO;
}

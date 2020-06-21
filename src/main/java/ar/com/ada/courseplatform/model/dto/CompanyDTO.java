package ar.com.ada.courseplatform.model.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "cuil", "adress", "phone", "category", "foundationYear"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CompanyDTO implements Serializable {

    //attr
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
    private Long cuil;

    @NotBlank(message = "adress is required")
    private String adress;

    @NotNull(message = "phone is required")
    @Positive(message = "only positive values")
    private Integer phone;

    @NotBlank(message = "category is required")
    private String category;

    @NotNull(message = "foundation year is required")
    @Past(message = "the foundation year must be past or present date")
    private Year foundationYear;

    @NotNull(message = "comoany_id is required")
    private Long companyId;

    //relationship
    private TypeOfCompanyDTO typeOfCompanyDTO;

    private ManagerDTO managerDTO;


}

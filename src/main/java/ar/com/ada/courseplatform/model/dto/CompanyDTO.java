package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "cuil", "adress", "phone", "category", "foundationYear"})
public class CompanyDTO implements Serializable {

    //attr
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
    @Positive(message = "only positive values")
    private Integer cuil;

    @NotBlank(message = "adress is required")
    private String adress;

    @NotNull(message = "phone is required")
    @Positive(message = "only positive values")
    private Integer phone;

    @NotBlank(message = "category is required")
    private String category;

    @NotNull(message = "foundation year is required")
    @PastOrPresent(message = "the foundation year must be past or present date")
    @JsonFormat(pattern = "yyyy")
    private Date foundationYear;

    //relationship
    private TypeOfCompanyDTO typeOfCompanyDTO;

    public CompanyDTO(Long id, @NotBlank(message = "name is required") String name, @NotNull(message = "cuil is required") @Positive(message = "only positive values") Integer cuil, @NotBlank(message = "adress is required") String adress, @NotNull(message = "phone is required") @Positive(message = "only positive values") Integer phone, @NotBlank(message = "category is required") String category, @NotNull(message = "foundation year is required") @PastOrPresent(message = "the foundation year must be past or present date") Date foundationYear, TypeOfCompanyDTO typeOfCompanyDTO) {
        this.id = id;
        this.name = name;
        this.cuil = cuil;
        this.adress = adress;
        this.phone = phone;
        this.category = category;
        this.foundationYear = foundationYear;
        this.typeOfCompanyDTO = typeOfCompanyDTO;
    }

    public CompanyDTO(@NotBlank(message = "name is required") String name, @NotNull(message = "cuil is required") @Positive(message = "only positive values") Integer cuil, @NotBlank(message = "adress is required") String adress, @NotNull(message = "phone is required") @Positive(message = "only positive values") Integer phone, @NotBlank(message = "category is required") String category, @NotNull(message = "foundation year is required") @PastOrPresent(message = "the foundation year must be past or present date") Date foundationYear, TypeOfCompanyDTO typeOfCompanyDTO) {
        this.name = name;
        this.cuil = cuil;
        this.adress = adress;
        this.phone = phone;
        this.category = category;
        this.foundationYear = foundationYear;
        this.typeOfCompanyDTO = typeOfCompanyDTO;
    }
}

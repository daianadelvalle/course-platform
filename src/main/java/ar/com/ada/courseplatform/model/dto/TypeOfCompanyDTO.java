package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "category"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TypeOfCompanyDTO implements Serializable {

    //attr
    private Long id;

    // tipo de sociedad comercial, se cargan al inicio con los data loader
    @NotBlank(message = "name is required")
    private String category;

    //constructors
    private Set<CompanyDTO> company;

    public TypeOfCompanyDTO(Long id, String category, Set<CompanyDTO> company) {
        this.id = id;
        this.category = category;
        this.company = company;
    }

    public TypeOfCompanyDTO(String category, Set<CompanyDTO> company) {
        this.category = category;
        this.company = company;
    }

    //setters
    public TypeOfCompanyDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public TypeOfCompanyDTO setCompany(Set<CompanyDTO> company) {
        this.company = company;
        return this;
    }
}

package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"name", "last_name", "identification_type", "identification", "position", "email"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ManagerDTO {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "identification type is required")
    private String identificationType;

    @NotNull(message = "identification is required")
    @Positive(message = "only positive values")
    private Integer identification;

    @NotBlank(message = "name is required")
    private String position;

    @NotBlank(message = "email is required")
    @Email(message = "not format valid")
    private String email;

    @NotNull(message = "company_id is required")
    private Long companyId;

    //relationship
    private CompanyDTO companyDTO;

    public ManagerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ManagerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public ManagerDTO setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
        return this;

    }

    public ManagerDTO setIdentification(Integer identification) {
        this.identification = identification;
        return this;

    }

    public ManagerDTO setPosition(String position) {
        this.position = position;
        return this;

    }

    public ManagerDTO setEmail(String email) {
        this.email = email;
        return this;

    }

    public ManagerDTO setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;

    }
}

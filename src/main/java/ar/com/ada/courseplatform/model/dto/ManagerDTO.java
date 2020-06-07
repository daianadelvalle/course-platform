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

    //relationship
    private CompanyDTO companyDTO;
}

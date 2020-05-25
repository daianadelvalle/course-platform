package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"name", "lastName", "identificationType", "identification", "position", "email"})
public class ManagerDTO implements Serializable {

    //attr
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "name is required")
    private String lastName;

    @NotBlank(message = "name is required")
    private String identificationType;

    @NotNull(message = "identification is requeride")
    @Positive(message = "only positive values")
    private Integer identification;

    @NotBlank(message = "name is required")
    private String position;

    @NotBlank(message = "name is required")
    @Email(message = "not format valid")
    private String email;

    //relationship
    private Set<CompanyDTO> company;

    public ManagerDTO(Long id, String name, String lastName, String identificationType, Integer identification,
                      String position, String email, Set<CompanyDTO> company) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.position = position;
        this.email = email;
        this.company = company;
    }

    public ManagerDTO(String name, String lastName, String identificationType,
                      Integer identification, String position, String email, Set<CompanyDTO> company) {
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.position = position;
        this.email = email;
        this.company = company;
    }
}

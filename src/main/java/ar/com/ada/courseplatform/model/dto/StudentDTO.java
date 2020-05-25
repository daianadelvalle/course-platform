package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "lastName", "birthdate", "gender", "adress"})
public class StudentDTO implements Serializable {

    //attr
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotNull(message = "birthdate is required")
    @Past(message = "the birthdate must be past date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotBlank(message = "gender is required")
    private String gender;

    @NotBlank(message = "name is required")
    private String adress;

    public StudentDTO(Long id, String name, String lastName, LocalDate birthdate, String gender, String adress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.adress = adress;
    }

    public StudentDTO(String name, String lastName, LocalDate birthdate, String gender, String adress) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.adress = adress;
    }
}

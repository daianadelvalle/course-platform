package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Manager")
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "identification_type", nullable = false, length = 50)
    private String identificationType;

    @Column(nullable = false, length = 15)
    private Integer identification;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, length = 200)
    private String email;

    @OneToOne
    @JoinColumn(name = "company_id", unique = true) //TODO: SI FALLA SE BORRA EL UNIQUE
    private Company company;

    public void addCompany(Company company) {
        this.company = company;
    }


    public Manager setName(String name) {
        this.name = name;
        return this;
    }

    public Manager setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Manager setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
        return this;
    }

    public Manager setIdentification(Integer identification) {
        this.identification = identification;
        return this;
    }

    public Manager setPosition(String position) {
        this.position = position;
        return this;
    }

    public Manager setEmail(String email) {
        this.email = email;
        return this;
    }

    public Manager setCompany(Company company) {
        this.company = company;
        return this;
    }

    /*
    JSON
{
	"name": "Claudia",
	"last_name": "Moratti",
	"identification_type": "DNI",
	"identification": 38598741,
	"position": "representante legal",
	"email": "claud.ia@glov.com",
	"company_id": 1
}

	*/
}

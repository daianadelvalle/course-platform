package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate birthdate;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 200)
    private String adress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentHasCourse> studentHasCourses;

    @OneToOne(mappedBy = "student")
    private SocioEconomicStudy socioEconomicStudy;

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Student setAdress(String adress) {
        this.adress = adress;
        return this;
    }

        /*
    JSON
{
    "id": 1,
    "name": "Valentin",
    "last_name": "Delvalle",
    "birthdate": "2008-05-20",
    "gender": "masculino",
    "adress": "Olivera Lavie 1258"
}

	*/
}

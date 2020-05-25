package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthdate;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 200)
    private String adress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentHasCourse> studentHasCourses;

    public Student(String name, String lastName, Date birthdate, String gender, String adress, Set<StudentHasCourse> studentHasCourses) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.adress = adress;
        this.studentHasCourses = studentHasCourses;
    }



    public Student(Long id) {
        this.id = id;
    }

}

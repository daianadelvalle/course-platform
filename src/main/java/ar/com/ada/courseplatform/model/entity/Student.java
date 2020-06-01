package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
    private Date birthdate;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 200)
    private String adress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentHasCourse> studentHasCourses;

}

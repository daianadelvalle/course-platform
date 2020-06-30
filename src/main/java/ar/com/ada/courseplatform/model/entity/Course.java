package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, length = 100)
    private String modality;

    @Column(nullable = false, length = 50)
    private Double cost;

    //carga horaria
    @Column(nullable = false, length = 6)
    private Integer workload;

    @Column(nullable = false, length = 100)
    private String category;

    //cupos
    @Column(nullable = false, length = 40)
    private Integer quota;

    //cantidad de becas
    @Column(nullable = false, length = 40)
    private Integer scolarship;


    //adjudicación directa inicializado a 0
    @Column(name = "direct_award", nullable = false, length = 40)
    private Integer directAward;

    //contador de becas
    @Column(name = "scolarship_accountant", nullable = false)
    private Integer scolarshipAccountant;

    @Column(name = "available", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean available;

    //relationship

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<StudentHasCourse> studentHasCourses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    /*

    JSON
    {
        "name": "Desarrollo Backend",
            "description": "Curso presencial de 400 de desarrollo backend, Java 8 con base de datos como MySQL, Spring Boot, Hivernate, y implementaciòn de seguridad y API-rest",
            "modality": "Prescencial",
            "cost": 80000,
            "workload": 400,
            "category": "sistemas",
            "quota": 30,
            "scolarship": 15,
            "direct_award": 0,
            "scolarship_accountant": 0,
            "available":true,
            "company_id":1
    }

     */

}

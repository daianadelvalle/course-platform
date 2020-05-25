package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity(name = "Course")
public class Course {

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
    @Column(name = "direct_award", nullable = false, length = 40, precision = 0)
    private Integer directAward;

    //contador de becas
    @Column(name = "scolarship_accountant", nullable = false, length = 40, precision = 0)
    private Integer scolarshipAccountant;

    //relationship

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<StudentHasCourse> studentHasCourses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Course(String name, String description, String modality, Double cost, Integer workload, String category, Integer quota, Integer scolarship, Integer directAward, Integer scolarshipAccountant) {
        this.name = name;
        this.description = description;
        this.modality = modality;
        this.cost = cost;
        this.workload = workload;
        this.category = category;
        this.quota = quota;
        this.scolarship = scolarship;
        this.directAward = directAward;
        this.scolarshipAccountant = scolarshipAccountant;
    }

    public Course(Long id) {
        this.id = id;
    }
}

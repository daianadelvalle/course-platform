package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Socio_economic_study")
public class SocioEconomicStudy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean study;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean work;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean incomes;

    @Column(name = "amount_of_incomes", length = 100)
    private Double amountOfIncomes;

    @Column(name = "family_in_charge", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean familyInCharge;

    @Column(name = "numbers_of_family_in_charge", length = 30)
    private Integer numbersOfFamilyInCharge;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public void addStudent(Student student) { this.student = student; }
}

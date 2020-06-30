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

    public SocioEconomicStudy setId(Long id) {
        this.id = id;
        return this;
    }

    public SocioEconomicStudy setStudy(Boolean study) {
        this.study = study;
        return this;
    }

    public SocioEconomicStudy setWork(Boolean work) {
        this.work = work;
        return this;
    }

    public SocioEconomicStudy setIncomes(Boolean incomes) {
        this.incomes = incomes;
        return this;
    }

    public SocioEconomicStudy setAmountOfIncomes(Double amountOfIncomes) {
        this.amountOfIncomes = amountOfIncomes;
        return this;
    }

    public SocioEconomicStudy setFamilyInCharge(Boolean familyInCharge) {
        this.familyInCharge = familyInCharge;
        return this;
    }

    public SocioEconomicStudy setNumbersOfFamilyInCharge(Integer numbersOfFamilyInCharge) {
        this.numbersOfFamilyInCharge = numbersOfFamilyInCharge;
        return this;
    }

    public SocioEconomicStudy setStudent(Student student) {
        this.student = student;
        return this;
    }

    public void addStudent(Student student) {
        this.student = student;
    }
/*
    {
        "id": 1,
        "study": true,
        "work": false,
         "incomes": false,
         "family_in_charge": false
    }

 */
}

package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "Socio_economic_study")
public class SocioEconomicStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean study;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean work;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean incomes;

    @Column(name = "amount_of_incomes", nullable = true, length = 100)
    private Double amountOfIncomes;

    @Column(name = "family_in_charge", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean familyInCharge;

    @Column(nullable = true, length = 30)
    private Integer numbersOfFamilyInCharge;

    @JoinColumn(name = "student_id", unique =true, nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public SocioEconomicStudy(Boolean study, Boolean work, Boolean incomes, Double amountOfIncomes, Boolean familyInCharge, Integer numbersOfFamilyInCharge) {
        this.study = study;
        this.work = work;
        this.incomes = incomes;
        this.amountOfIncomes = amountOfIncomes;
        this.familyInCharge = familyInCharge;
        this.numbersOfFamilyInCharge = numbersOfFamilyInCharge;
    }

    public SocioEconomicStudy(Long id) {
        this.id = id;
    }
}

package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 15 )
    private Integer cuil;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String adress;

    @Column(nullable = false, length = 20)
    private Integer phone;

    @Column(nullable = false, length = 80)
    private String category;

    @Column(name = "foundation_year", nullable = false, columnDefinition = "YEAR")
    private Date foundationYear;

    //relationship
    @OneToMany(mappedBy = "company")
    private List<Course> courses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "type_of_company_id", nullable = false)
    private TypeOfCompany typeOfCompany;



    public Company(String name, Integer cuil, String adress, Integer phone, String category, Date foundationYear) {
        this.name = name;
        this.cuil = cuil;
        this.adress = adress;
        this.phone = phone;
        this.category = category;
        this.foundationYear = foundationYear;
    }

    public Company(Long id) {
        this.id = id;
    }
}

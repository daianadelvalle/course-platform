package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Long cuil;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String adress;

    @Column(nullable = false)
    private Integer phone;

    @Column(nullable = false, length = 80)
    private String category;

    @Column(name = "foundation_year", nullable = false, length = 4)
    private Year foundationYear;

    //relationship
    @OneToMany(mappedBy = "company")
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "type_of_company_id")
    private TypeOfCompany typeOfCompany;

    @JoinColumn(name = "manager_id", unique = true)
    @OneToOne(mappedBy = "company")
    private Manager manager;

    public Company addManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Company setCuil(Long cuil) {
        this.cuil = cuil;
        return this;
    }

    public Company setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Company setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public Company setCategory(String category) {
        this.category = category;
        return this;
    }

    public Company setFoundationYear(Year foundationYear) {
        this.foundationYear = foundationYear;
        return this;
    }
}

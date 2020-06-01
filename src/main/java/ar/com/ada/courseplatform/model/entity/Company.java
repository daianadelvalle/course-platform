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
@Entity(name = "Company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 15)
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
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "type_of_company_id", nullable = false)
    private TypeOfCompany typeOfCompany;

}

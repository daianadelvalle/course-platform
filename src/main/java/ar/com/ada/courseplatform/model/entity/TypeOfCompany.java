package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity(name = "type_of_company")
public class TypeOfCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String category;

    @OneToMany(mappedBy = "typeOfCompany", cascade = CascadeType.ALL)
    private Set<Company> companies;

    public TypeOfCompany(String category) {
        this.category = category;
    }

    public TypeOfCompany(Long id) {
        this.id = id;
    }
}

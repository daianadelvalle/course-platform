package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(name = "identification_type", nullable = false, length = 50)
    private String identificationType;

    @Column(nullable = false, length = 15)
    private Integer identification;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, length = 200)
    private String email;

    @JoinColumn(name = "company_id", unique =true, nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

    public Manager(String name, String lastName, String identificationType, Integer identification, String position, String email) {
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.position = position;
        this.email = email;
    }

    public Manager(Long id) {
        this.id = id;
    }
}

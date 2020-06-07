package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Manager")
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "identification_type", nullable = false, length = 50)
    private String identificationType;

    @Column(nullable = false, length = 15)
    private Integer identification;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, length = 200)
    private String email;

    @JoinColumn(name = "company_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;


}

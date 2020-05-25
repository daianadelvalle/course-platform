package ar.com.ada.courseplatform.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "category"})
public class TypeOfCompanyDTO implements Serializable {

    //attr
    private Long id;
    private String category;

    private Set<CompanyDTO> company;

    public TypeOfCompanyDTO(Long id, String category, Set<CompanyDTO> company) {
        this.id = id;
        this.category = category;
        this.company = company;
    }

    public TypeOfCompanyDTO(String category, Set<CompanyDTO> company) {
        this.category = category;
        this.company = company;
    }
}

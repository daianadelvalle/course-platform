package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfCompanyRepository extends JpaRepository<TypeOfCompany, Long> {
}

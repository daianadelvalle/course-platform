package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}

package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("socioEconomicStudyRepository")
public interface SocioEconomicStudyRepository extends JpaRepository<SocioEconomicStudy, Long> {
}

package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}

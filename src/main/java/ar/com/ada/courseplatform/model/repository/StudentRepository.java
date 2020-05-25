package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

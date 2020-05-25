package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentHasCourseRepository extends JpaRepository<StudentHasCourse, Long> {
}

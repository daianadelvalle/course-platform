package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import ar.com.ada.courseplatform.model.entity.StudentHasCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentHasCourseRepository")
public interface StudentHasCourseRepository extends JpaRepository<StudentHasCourse, StudentHasCourseId> {
}

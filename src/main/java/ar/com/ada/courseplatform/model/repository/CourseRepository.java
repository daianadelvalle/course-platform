package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {
}

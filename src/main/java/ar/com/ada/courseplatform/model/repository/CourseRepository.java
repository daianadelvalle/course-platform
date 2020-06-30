package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM Course c WHERE available = true",
            nativeQuery = true)
    Page<Course> findCourseByAvailableQuota(@Param("available") Boolean available, Pageable pageable);

    @Query(value = "SELECT * FROM Course c WHERE category = :category", nativeQuery = true)
    Page<Course> findAllCoursesByCategory(@Param("category") String category, Pageable pageable);

    @Query(value = "SELECT * FROM Course c WHERE company_id = :companyId",
            nativeQuery = true)
    Page<Course> findAllCoursesByCompany(@Param("companyId") Long companyId, Pageable pageable);

    @Query(value = "SELECT *  FROM Course c INNER JOIN student_has_course shc ON c.id=shc.finalized = true",
            nativeQuery = true)
    Page<Course> findAllCoursesByStudentsFinalized(@Param("finalized") Boolean finalized, Pageable pageable);

    @Query(value = "SELECT *  FROM Course c INNER JOIN student_has_course shc ON c.id=shc.finalized = false",
            nativeQuery = true)
    Page<Course> findAllCoursesByStudentsInProgress(@Param("finalized") Boolean finalized, Pageable pageable);

    @Query(value = "SELECT * FROM Course c WHERE c.company_id = :companyId and c.category = :category",
            nativeQuery = true)
    Page<Course> findAllCoursesByCompanyAndCategory(@Param("companyId") Long companyId, @Param("category") String category, Pageable pageable);
}

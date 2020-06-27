package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Student_has_Course")
public class StudentHasCourse implements Serializable {

    @EmbeddedId
    private StudentHasCourseId id;


    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    //tipo de solicitud del curso: directa o beca
    @Column(name = "direct_award", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean directAward;

    //aprobada o desaprovada la solicitud de cupo
    @Column(name = "approval_status", columnDefinition = "TINYINT(1)")
    private Boolean approvalStatus;

    //finalizado o no finalizado el curso
    @Column( columnDefinition = "TINYINT(1)")
    private Boolean finalized;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentHasCourse)) return false;
        StudentHasCourse that = (StudentHasCourse) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(directAward, that.directAward) &&
                Objects.equals(approvalStatus, that.approvalStatus) &&
                Objects.equals(finalized, that.finalized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, directAward, approvalStatus, finalized);
    }
}

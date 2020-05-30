package ar.com.ada.courseplatform.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@Entity(name = "Student_has_Course")
public class StudentHasCourse implements Serializable {

    @EmbeddedId
    private StudentHasCourse id;


    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    //tipo de solicitud del curso: directa o beca
    @Column(name = "type_of_request", nullable = false, length = 50)
    private String typeOfRequest;

    //aprobada o desaprovada la solicitud de cupo
    @Column(name = "approval_status", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean approvalStatus;

    //finalizado o no finalizado el curso
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean finalized;

    public StudentHasCourse(String typeOfRequest, Boolean approvalStatus, Boolean finalized) {
        this.typeOfRequest = typeOfRequest;
        this.approvalStatus = approvalStatus;
        this.finalized = finalized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentHasCourse)) return false;
        StudentHasCourse that = (StudentHasCourse) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(typeOfRequest, that.typeOfRequest) &&
                Objects.equals(approvalStatus, that.approvalStatus) &&
                Objects.equals(finalized, that.finalized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, typeOfRequest, approvalStatus, finalized);
    }
}

package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.component.BusinessLogicExceptionComponent;
import ar.com.ada.courseplatform.model.dto.StudentHasCourseDTO;
import ar.com.ada.courseplatform.model.entity.Course;
import ar.com.ada.courseplatform.model.entity.Student;
import ar.com.ada.courseplatform.model.entity.StudentHasCourse;
import ar.com.ada.courseplatform.model.entity.StudentHasCourseId;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.mapper.StudentHasCourseMapper;
import ar.com.ada.courseplatform.model.repository.CourseRepository;
import ar.com.ada.courseplatform.model.repository.StudentHasCourseRepository;
import ar.com.ada.courseplatform.model.repository.StudentRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("studentHasCourseServices")
public class StudentHasCourseServices {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;


    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("studentHasCourseRepository")
    private StudentHasCourseRepository studentHasCourseRepository;

    private final StudentHasCourseMapper studentHasCourseMapper = StudentHasCourseMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    //solicitudes al curso
    public StudentHasCourseDTO requestToCourse(StudentHasCourseDTO dto, Long studentId, Long courseId) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Student", studentId));

        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Course", courseId));

        StudentHasCourseDTO studentHasCourseDTO;
        if (dto.getDirectAward()) {
            studentHasCourseDTO = this.saveStudentHasCourseToRequestAdward(student, course);
        } else {
            studentHasCourseDTO = this.saveStudentHasCourseToScolarship(student, course);
        }
        return studentHasCourseDTO;
    }

    public StudentHasCourseDTO saveStudentHasCourseToRequestAdward(Student student, Course course) {
        if (course.getAvailable() == false && course.getDirectAward() == 0) {
            logicExceptionComponent.throwExceptionNotAvailable(course.getName());
        }
        StudentHasCourseId studentHasCourseId = new StudentHasCourseId()
                .setStudentId(student.getId())
                .setCourseId(course.getId());

        StudentHasCourse studentHasCourseToSave = new StudentHasCourse();
        studentHasCourseToSave.setId(studentHasCourseId);
        studentHasCourseToSave.setCourse(course);
        studentHasCourseToSave.setStudent(student);
        studentHasCourseToSave.setDirectAward(true);
        studentHasCourseToSave.setApprovalStatus(true);
        studentHasCourseToSave.setFinalized(false);
        StudentHasCourse studentHasCourseSaved = studentHasCourseRepository.save(studentHasCourseToSave);

        int directAward = course.getDirectAward() - 1;
        course.setDirectAward(directAward);
        courseRepository.save(course);

        if (course.getDirectAward() == 0 && course.getScolarshipAccountant() == 0) {
            course.setAvailable(false);
            courseRepository.save(course);
        }

        StudentHasCourseDTO studentHasCourseDTO = studentHasCourseMapper.toDto(studentHasCourseSaved, context);

        return studentHasCourseDTO;
    }

    public StudentHasCourseDTO saveStudentHasCourseToScolarship(Student student, Course course) {
        StudentHasCourseId studentHasCourseId = new StudentHasCourseId()
                .setStudentId(student.getId())
                .setCourseId(course.getId());

        StudentHasCourse studentHasCourseToSave = new StudentHasCourse();
        studentHasCourseToSave.setId(studentHasCourseId);
        studentHasCourseToSave.setCourse(course);
        studentHasCourseToSave.setStudent(student);
        studentHasCourseToSave.setDirectAward(false);
        studentHasCourseToSave.setApprovalStatus(null);
        studentHasCourseToSave.setFinalized(false);
        StudentHasCourse studentHasCourseSaved = studentHasCourseRepository.save(studentHasCourseToSave);

        StudentHasCourseDTO studentHasCourseDTO = studentHasCourseMapper.toDto(studentHasCourseSaved, context);


        return studentHasCourseDTO;
    }

    public StudentHasCourseDTO saveApprovalStatusScolarship(StudentHasCourseDTO dto, Long studentId, Long courseId) {
        StudentHasCourseId studentHasCourseId = new StudentHasCourseId()
                .setStudentId(studentId)
                .setCourseId(courseId);

        StudentHasCourse studentHasCourse = studentHasCourseRepository
                .findById(studentHasCourseId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("StudentHasCourse", studentHasCourseId));
        Integer scolarshipAccountant = studentHasCourse.getCourse().getScolarshipAccountant();

        if (scolarshipAccountant == 0)
            logicExceptionComponent.throwExceptionNotAvailable(studentHasCourse.getCourse().getName());
        if (dto.getApprovalStatus()) {
            studentHasCourse.setApprovalStatus(true);
            studentHasCourse.getCourse().setScolarshipAccountant(scolarshipAccountant - 1);

        } else {
            studentHasCourse.setApprovalStatus(false);
        }

        StudentHasCourseDTO studentHasCourseDTO = studentHasCourseMapper.toDto(studentHasCourse, context);

        return studentHasCourseDTO;

    }

    public StudentHasCourseDTO courseFinalized(StudentHasCourseDTO dto, Long studentId, Long courseId) {

        StudentHasCourseId studentHasCourseId = new StudentHasCourseId()
                .setStudentId(studentId)
                .setCourseId(courseId);

        StudentHasCourse studentHasCourse = studentHasCourseRepository
                .findById(studentHasCourseId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("StudentHasCourse", studentHasCourseId));
        if (!studentHasCourse.getFinalized())
            studentHasCourse.setFinalized(true);

        StudentHasCourseDTO studentHasCourseDTO = studentHasCourseMapper.toDto(studentHasCourse, context);

        return studentHasCourseDTO;

    }
}


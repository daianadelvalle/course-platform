package ar.com.ada.courseplatform.component;

import ar.com.ada.courseplatform.exception.ApiEntityError;
import ar.com.ada.courseplatform.exception.BusinessLogicException;
import ar.com.ada.courseplatform.model.entity.StudentHasCourseId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public void throwExceptionEntityNotFound(String entityName, Long id) {
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The " + entityName + " with id '" + id + "' does not exist"
        );

        throw new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }

    public RuntimeException throwExceptionEntityNotFound(String entityName, StudentHasCourseId id) {
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The " + entityName + " with Course id '" + id.getCourseId() + "' and Participant id '" + id.getStudentId() + "' does not exist"
        );
        return new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }

    public RuntimeException getExceptionEntityNotFound(String entityName, Long id) {
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The " + entityName + " with id '" + id + "' does not exist"
        );

        return new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }

    public void throwExceptionNotAvailable(String courseName) {
        ApiEntityError apiEntityError = new ApiEntityError(
                courseName,
                "Not available",
                "Sorry. This course has no available places."
        );

        throw new BusinessLogicException(
                courseName + " Not available",
                HttpStatus.BAD_REQUEST,
                apiEntityError
        );
    }
}

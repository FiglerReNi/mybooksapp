package hu.tmx.mybooksapp.exception;

import hu.tmx.mybooksapp.controller.AuthorRestController;
import hu.tmx.mybooksapp.controller.BookRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;


@ControllerAdvice(assignableTypes = {AuthorRestController.class, BookRestController.class})
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ListItemNotFoundException.class)
    public ResponseEntity<Object> springHandleNotFound(Exception exception) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
                "status", HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "message", exception.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public void springHandleNoSuchElementException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void springHandleMethodArgumentTypeMismatchException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception exception,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return super.handleExceptionInternal(exception, Objects.isNull(body) ? new ResponseEntity<Object>(status, HttpStatus.valueOf(exception.getMessage())) : body, headers, status, request);
    }

}

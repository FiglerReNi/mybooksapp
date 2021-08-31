package hu.tmx.mybooksapp.exception;

import hu.tmx.mybooksapp.controller.AuthorController;
import hu.tmx.mybooksapp.controller.BookController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {AuthorController.class, BookController.class})
public class ExceptionGeneral {

    @ExceptionHandler
    public String exceptionHandler(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "exceptionHandler";
    }
}

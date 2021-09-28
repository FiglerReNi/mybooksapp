package hu.tmx.mybooksapp.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorGeneralController implements ErrorController {


    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String error(Model model, HttpServletRequest request) {
        ServletWebRequest ra = new ServletWebRequest(request);
        Map<String, Object> error = errorAttributes.getErrorAttributes(ra, ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.STACK_TRACE, ErrorAttributeOptions.Include.MESSAGE,
                ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));

		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("status", error.get("status"));
		model.addAttribute("path", error.get("path"));

        return "errorHandler";
    }

}

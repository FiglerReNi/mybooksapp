package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.entity.User;
import hu.tmx.mybooksapp.service.EmailService;
import hu.tmx.mybooksapp.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user) throws Exception {
        userService.registerUser(user);
        emailService.sendMessage(user.getEmail(), user.getActivation(), user.getUsername());
        return "auth/login";
    }

    @GetMapping("/activation/{code}")
    public String activation(@PathVariable(value="code") String code) throws NotFoundException {
        userService.userActivation(code);
        return "auth/login";
    }
}

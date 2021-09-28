package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${project.activation.url}")
    private String path;

    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(String email, String code, String name){
        SimpleMailMessage msg;
            msg = new SimpleMailMessage();
            msg.setFrom(MESSAGE_FROM);
            msg.setTo(email);
            msg.setSubject("Sikeres regisztrálás");
            msg.setText("Kedves " +name + "! \n\n Köszönjük, hogy regisztráltál az oldalunkra \n\n Kérlek aktiváld az email címed és kattints a linkre: \n\n"
                    + path + code);
            javaMailSender.send(msg);
    }
}

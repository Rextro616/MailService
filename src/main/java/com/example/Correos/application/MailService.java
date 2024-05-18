package com.example.Correos.application;

import com.example.Correos.domain.entities.Mail;
import com.example.Correos.domain.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MailService implements ServiceRepository {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public String sendMails(Mail mail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(mail.getTo());
            mailMessage.setSubject(mail.getSubject());
            mailMessage.setText(mail.getBody());

            mailSender.send(mailMessage);
            return "Mensaje enviado correctamente";
        } catch (Error error){
            return error.toString();
        }
    }
}

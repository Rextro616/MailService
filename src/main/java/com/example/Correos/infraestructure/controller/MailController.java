package com.example.Correos.infraestructure.controller;

import com.example.Correos.application.MailService;
import com.example.Correos.domain.entities.Mail;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping()
    public ResponseEntity<String> sendMail(@RequestBody Mail mail){
        String answer = mailService.sendMails(mail);
        return ResponseEntity.ok().body(answer);
    }


}

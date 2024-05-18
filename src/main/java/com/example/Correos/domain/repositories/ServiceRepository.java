package com.example.Correos.domain.repositories;

import com.example.Correos.domain.entities.Mail;

public interface ServiceRepository {
    String sendMails(Mail mail);
}

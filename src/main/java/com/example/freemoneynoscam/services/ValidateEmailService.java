package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.models.Email;
import com.example.freemoneynoscam.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmailService {

    @Autowired
    EmailRepository emailRepository;

    public boolean isEmailValid(String email) {
        if (email == null) return false;
        if (!email.contains("@")) return false;
        if (email.indexOf("@") == 0) return false;
        if (email.indexOf("@") == email.length() - 1) return false;
        if (email.chars().filter(c -> c == '@').count() != 1) return false;
        if (email.contains(" ")) return false;
        return true;
    }

    public void saveEmail(String email) {
        if (isEmailValid(email)) {
            Email newEmail = new Email();
            newEmail.setMail(email);
            emailRepository.save(newEmail);
        }
    }
}

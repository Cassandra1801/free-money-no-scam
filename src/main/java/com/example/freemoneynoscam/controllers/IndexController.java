package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

// Markerer denne klasse som en Spring MVC Controller
@Controller
public class IndexController {

    // Spring injicerer automatisk en instans af ValidateEmailService
    // Vi behøver ikke selv skrive "new ValidateEmailService()"
    @Autowired
    ValidateEmailService validator;

    // Håndterer GET-requests til "/" og returnerer index-siden
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Håndterer POST-requests til "/test" når formularen indsendes
    @PostMapping("/test")
    public String test(WebRequest dataFromForm) {
        // Henter værdien fra formularfeltet med name="email"
        String mail = dataFromForm.getParameter("email");

        // Validerer og gemmer emailen i databasen via servicen
        validator.saveEmail(mail);

        // Sender brugeren tilbage til forsiden
        return "redirect:/";
    }
}

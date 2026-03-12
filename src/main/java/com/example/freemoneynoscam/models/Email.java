package com.example.freemoneynoscam.models;

import javax.persistence.*;

// Fortæller Spring at denne klasse svarer til en tabel i databasen
@Entity
public class Email {

    // Primærnøgle — hver række har et unikt id
    @Id
    // Databasen tæller automatisk op: 1, 2, 3...
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kolonnen i databasen hedder "e_mail", men variablen hedder "mail" i Java
    @Column(name = "e_mail")
    private String mail;

    // Tom constructor — kræves af Spring/JPA for at kunne oprette objekter
    public Email() {}

    // Constructor til at oprette et Email-objekt med en værdi
    public Email(String mail) {
        this.mail = mail;
    }

    // Getter — returnerer emailadressen
    public String getMail() {
        return mail;
    }

    // Setter — sætter emailadressen
    public void setMail(String mail) {
        this.mail = mail;
    }
}

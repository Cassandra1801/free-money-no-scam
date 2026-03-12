package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface der håndterer al kommunikation med databasen
// JpaRepository giver os gratis metoder som: save(), findAll(), findById(), delete()
// <Email, Long> betyder: vi arbejder med Email-objekter, og id er af typen Long
public interface EmailRepository extends JpaRepository<Email, Long> {}

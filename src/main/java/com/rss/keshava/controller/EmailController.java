package com.rss.keshava.controller;

import com.rss.keshava.domain.Email;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public Status sendMails(@RequestBody Email email) {
        return emailService.sendMails(email);
    }
}

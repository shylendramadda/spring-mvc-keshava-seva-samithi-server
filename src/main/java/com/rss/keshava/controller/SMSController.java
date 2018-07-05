package com.rss.keshava.controller;

import com.rss.keshava.domain.SMS;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/sms")
public class SMSController {

    @Autowired
    private SmsService smsService;

    @PostMapping
    public Status sendSMSs(@RequestBody SMS sms) {
        return smsService.sendSmss(sms);
    }
}

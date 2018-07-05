package com.rss.keshava.service;

import com.rss.keshava.domain.SMS;
import com.rss.keshava.domain.Status;
import com.rss.keshava.utils.Constants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC92a6bfa5f1e2330da5befff1fa0221c8";
    public static final String AUTH_TOKEN =
            "6e650ae1cae3507e9eb359fdeb15b8e7";

    public Status sendSmss(SMS sms) {

        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message
                    .creator(new PhoneNumber("+919398960207"), // to
                            new PhoneNumber("+919908069807"), // from
                            sms.getMessage())
                    .create();

            System.out.println(message.getSid());
            return new Status(Constants.SUCCESS, "SMS sent successfully", null, "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.FAILED, "Failed to send SMSs", null, "");
        }
    }
}

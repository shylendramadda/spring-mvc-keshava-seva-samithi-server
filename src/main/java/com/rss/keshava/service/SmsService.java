package com.rss.keshava.service;

import com.rss.keshava.domain.SMS;
import com.rss.keshava.domain.Status;
import com.rss.keshava.utils.Constants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
                    .creator(new PhoneNumber("+91" + sms.getToNumber()), // to
                            new PhoneNumber("+18084009326"), // from this is trail account number (only it works with this for now)
                            sms.getBody())
                    .create();
            System.out.println(message.getSid());

            /*RestTemplate rt = new RestTemplate();
            rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());

            // Balu office url for testing sms
            String url = "https://hapi.smsapi.org/SendSMS.aspx?UserName=Evolve_SMS&password=170393&MobileNo=" + sms.getToNumber() + "&SenderID=EVOLVE&CDMAHeader=EVOLVE&Message=" + sms.getBody();

            String smsResp = rt.getForObject(url, String.class);
            System.out.println(smsResp + "--------" + sms.getBody());*/

            return new Status(Constants.SUCCESS, "SMS sent successfully", null, sms);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.FAILED, "Failed to send SMSs", null, sms);
        }
    }
}

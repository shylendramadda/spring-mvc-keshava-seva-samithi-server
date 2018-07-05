package com.rss.keshava.service;

import com.rss.keshava.domain.SMS;
import com.rss.keshava.domain.Status;
import com.rss.keshava.utils.Constants;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    public Status sendSmss(SMS sms) {

        try {
            RestTemplate rt = new RestTemplate();
            rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());

            String url = "https://hapi.smsapi.org/SendSMS.aspx?UserName=Evolve_SMS&password=170393&MobileNo=" + sms.getToNumber() + "&SenderID=EVOLVE&CDMAHeader=EVOLVE&Message=" + sms.getBody();

            String smsResp = rt.getForObject(url, String.class);
            System.out.println(smsResp + "--------" + sms.getBody());

            /*try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
            // Build the parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            if (!mobileNumber.contains("+91")) {
            mobileNumber = "+91"+mobileNumber;
            }
            params.add(new BasicNameValuePair("To", mobileNumber));
            params.add(new BasicNameValuePair("From", "+12566002010"));
            params.add(new BasicNameValuePair("Body", msg));
            params.add(new BasicNameValuePair("MediaUrl", "http://3frameslab.com/"));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            System.out.println(message.getSid());
            } catch (TwilioRestException e) {
            e.printStackTrace();
            } */

            return new Status(Constants.SUCCESS, "SMS sent successfully", null, "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.FAILED, "Failed to send SMSs", null, "");
        }
    }
}

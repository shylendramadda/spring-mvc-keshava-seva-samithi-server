package com.rss.keshava.service;

import com.rss.keshava.domain.*;
import com.rss.keshava.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private DonorService donorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CommitteeMemberService committeeMemberService;

    @Autowired
    private StaffService staffService;


    public boolean send(Email eParams) {
        if (eParams.isHtml()) {
            try {
                sendHtmlMail(eParams);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else {
            return sendPlainTextMail(eParams);
        }
        return false;
    }

    private void sendHtmlMail(Email eParams) throws MessagingException {
        boolean isHtml = true;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
        helper.setReplyTo(eParams.getFrom());
        helper.setFrom(eParams.getFrom());
        helper.setSubject(eParams.getSubject());
        helper.setText(eParams.getBody(), isHtml);
        if (eParams.getCc().size() > 0) {
            helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
        }
        mailSender.send(message);
    }

    private boolean sendPlainTextMail(Email eParams) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            eParams.getTo().toArray(new String[eParams.getTo().size()]);

            mailMessage.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
            mailMessage.setReplyTo(eParams.getFrom());
            mailMessage.setFrom(eParams.getFrom());
            mailMessage.setSubject(eParams.getSubject());
            mailMessage.setText(eParams.getBody());
            if (eParams.getCc().size() > 0) {
                mailMessage.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
            }
            mailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Status sendMails(Email email) {

        List<String> donorMails = new ArrayList<>();
        List<String> studentMails = new ArrayList<>();
        List<String> commiteeMemberMails = new ArrayList<>();
        List<String> staffMails = new ArrayList<>();

        switch (email.getToWhome()) {
            case "Donors":
                Iterable<Donor> donorIterable = donorService.getAll();
                for (Donor donor : donorIterable) {
                    donorMails.add(donor.getEmail());
                }
                if (donorMails.size() > 0) {
                    Email email1 = new Email();
                    email1.setFrom(email.getFrom());
                    email1.setTo(donorMails);
                    email1.setSubject(email.getSubject());
                    email1.setBody(email.getBody());
                    boolean isSent = send(email1);
                    if (isSent) {
                        return new Status(Constants.SUCCESS, "Mails sent successfully", null, "");
                    } else {
                        return new Status(Constants.FAILED, "Failed to send mails", null, "");
                    }
                }
                break;
            case "Students":
                Iterable<Student> studentIterable = studentService.getAll();
                for (Student student : studentIterable) {
                    studentMails.add(student.getEmail());
                }
                if (studentMails.size() > 0) {
                    Email email1 = new Email();
                    email1.setFrom(email.getFrom());
                    email1.setTo(studentMails);
                    email1.setSubject(email.getSubject());
                    email1.setBody(email.getBody());
                    send(email1);
                    boolean isSent = send(email1);
                    if (isSent) {
                        return new Status(Constants.SUCCESS, "Mails sent successfully", null, "");
                    } else {
                        return new Status(Constants.FAILED, "Failed to send mails", null, "");
                    }
                }
                break;
            case "CommiteeMembers":
                Iterable<CommitteeMember> committeeMemberIterable = committeeMemberService.getAll();
                for (CommitteeMember committeeMember : committeeMemberIterable) {
                    commiteeMemberMails.add(committeeMember.getEmailId());
                }
                if (commiteeMemberMails.size() > 0) {
                    Email email1 = new Email();
                    email1.setFrom(email.getFrom());
                    email1.setTo(commiteeMemberMails);
                    email1.setSubject(email.getSubject());
                    email1.setBody(email.getBody());
                    send(email1);
                    boolean isSent = send(email1);
                    if (isSent) {
                        return new Status(Constants.SUCCESS, "Mails sent successfully", null, "");
                    } else {
                        return new Status(Constants.FAILED, "Failed to send mails", null, "");
                    }
                }
                break;
            case "Staff":
                Iterable<Staff> staffIterable = staffService.getAll();
                for (Staff staff : staffIterable) {
                    staffMails.add(staff.getEmailId());
                }
                if (staffMails.size() > 0) {
                    Email email1 = new Email();
                    email1.setFrom(email.getFrom());
                    email1.setTo(staffMails);
                    email1.setSubject(email.getSubject());
                    email1.setBody(email.getBody());
                    send(email1);
                    boolean isSent = send(email1);
                    if (isSent) {
                        return new Status(Constants.SUCCESS, "Mails sent successfully", null, "");
                    } else {
                        return new Status(Constants.FAILED, "Failed to send mails", null, "");
                    }
                }
                break;
        }
        return null;
    }
}
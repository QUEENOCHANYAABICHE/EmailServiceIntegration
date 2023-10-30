package com.example.emailserviceintegration.service.serviceImpl;

import com.example.emailserviceintegration.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private final JavaMailSender emailSender;
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.host}")
    private String  fromEmail;
    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {

        try { 
           SimpleMailMessage message = new SimpleMailMessage();
           message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
           message.setFrom(fromEmail);
           message.setTo(to);
           message.setText("Hey, this is working");
           emailSender.send(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void sendMimeMessageWithAttachments(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedImages(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmail(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}

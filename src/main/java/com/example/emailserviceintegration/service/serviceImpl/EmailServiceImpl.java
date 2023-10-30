package com.example.emailserviceintegration.service.serviceImpl;

import com.example.emailserviceintegration.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
     @Value()
    private final JavaMailSender mailSender;
    private String host;
    private String  fromEmail;
    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {

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

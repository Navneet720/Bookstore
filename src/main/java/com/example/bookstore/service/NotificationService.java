package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendConfirmationEmail(String email) {
        try {
            System.out.println("Sending email to: " + email);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Scheduled Bookstore Email");
            message.setText("Hello! This is your scheduled email from Bookstore App.");
            message.setFrom("Navneeypandey7208@gmail.com");
            mailSender.send(message);
            System.out.println("Email sent!");
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class EmailScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 * 9 * * ?")
    public void sendDailySummary() {
        System.out.println("Sending daily email summary at " + LocalTime.now());
        notificationService.sendConfirmationEmail("navneetpandey720@gmail.com");
    }
}
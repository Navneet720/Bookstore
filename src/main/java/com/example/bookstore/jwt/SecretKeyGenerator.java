package com.example.bookstore.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
import java.util.Base64;

@Configuration
public class SecretKeyGenerator {

    @Bean
    public String secretKey
            () {
        byte[] randomBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);
        String base64SecretKey = Base64.getEncoder().encodeToString(randomBytes);
        System.out.println("Generated Base64 Secret Key: " + base64SecretKey);
        return "bbxwAmqRt9Rsu+AVzotUtV2uYJjfHrLJD0wHEJcq55k=";
    }
}
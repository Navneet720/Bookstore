package com.example.bookstore.jwt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse {
    private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

}
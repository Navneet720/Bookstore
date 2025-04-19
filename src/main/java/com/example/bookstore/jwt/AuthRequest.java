package com.example.bookstore.jwt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    // Getters and setters
    @Schema(description = "Username for login", example = "admin")
    private String username;

    @Schema(description = "Password for login", example = "123")
    private String password;

//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}


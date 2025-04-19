package com.example.bookstore.controller;


import com.example.bookstore.jwt.AuthRequest;
import com.example.bookstore.jwt.AuthResponse;
import com.example.bookstore.jwt.JwtUtil;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private BookService bookService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        // Authenticate the user
        System.out.println(authRequest+"-------authrequest");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        List<String> roles = bookService.getUserRoles(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(authRequest.getUsername(), roles);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
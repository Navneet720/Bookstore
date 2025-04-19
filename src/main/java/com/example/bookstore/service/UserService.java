package com.example.bookstore.service;

import com.example.bookstore.model.UserRole;
import com.example.bookstore.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<String> getUserRoles(String username) {
        System.out.println(username+" <=====username");
        List<UserRole> userRoles = userRoleRepository.findByUsername(username);
        return userRoles.stream()
                .map(UserRole::getUserrole) // Extract role name
                .collect(Collectors.toList());
    }


}
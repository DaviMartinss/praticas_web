package com.web.server.server.controller;


import com.web.server.server.model.UserAccountModel;
import com.web.server.server.repositories.UserAccountRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
   
    @Autowired
    private UserAccountRepository userAccountRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @GetMapping
    public List<UserAccountModel> getAllUsers(){
        return userAccountRepository.findAll();
    }
    
    @PostMapping
    public UserAccountModel save(@RequestBody UserAccountModel userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccountRepository.saveAndFlush(userAccount);
    }


}

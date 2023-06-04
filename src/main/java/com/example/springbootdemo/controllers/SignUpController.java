package com.example.springbootdemo.controllers;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.springbootdemo.models.User;
import com.example.springbootdemo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpUser(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/signUp";

    }
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentLoginController {

    @GetMapping("/login")
    public String showLogin(
            @RequestParam("testId") Integer testId,
            Model model) {

        model.addAttribute("testId", testId);
        return "student/login";
    }
}
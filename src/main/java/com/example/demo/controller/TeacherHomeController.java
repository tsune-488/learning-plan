package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.TeacherUserDetails;

@Controller
@RequestMapping("/teacher")
public class TeacherHomeController {

    @GetMapping("/home")
    public String home(
            @AuthenticationPrincipal TeacherUserDetails userDetails,
            Model model) {

        model.addAttribute("teacher", userDetails.getTeacher());
        return "teacher/dashboard";
    }
}
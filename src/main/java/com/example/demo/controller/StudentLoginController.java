package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Students;
import com.example.demo.form.StudentLoginForm;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentLoginController {

    // DI
    private final StudentService studentService;

    // ログイン画面表示
    @GetMapping("/login")
    public String showLogin(
            @ModelAttribute("studentLoginForm") StudentLoginForm form,
            HttpSession session) {

        Integer testId = (Integer) session.getAttribute("testId");
        if (testId == null) {
            return "redirect:/students/error";
        }

        form.setTestId(testId);
        return "student/login";
    }

    // ログイン処理
    @PostMapping("/login")
    public String doLogin(
            @Valid @ModelAttribute("studentLoginForm") StudentLoginForm form,
            BindingResult result,
            HttpSession session,
            Model model) {

        if (result.hasErrors()) {
            return "student/login";
        }

        Students student = studentService.login(
                form.getStudentnumber(),
                form.getStudentpassword(),
                form.getTestId()
        );

        if (student == null) {
            model.addAttribute("error", "番号またはパスワードが違います");
            return "student/login";
        }

        session.setAttribute("studentId", student.getId());
        session.setAttribute("testId", form.getTestId());

        return "redirect:/students/learning";
    }  
    
}
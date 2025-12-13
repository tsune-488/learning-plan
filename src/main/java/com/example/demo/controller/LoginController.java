package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Teachers;
import com.example.demo.form.LoginForm;
import com.example.demo.service.TeachersService;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class LoginController {
	
	//DI
	private final TeachersService teachersService;
	
	//ログイン画面
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginForm",new LoginForm());
		return "teacherLogin";
	}
	
	//管理画面へ
	@PostMapping("/login")
	public String doLogin(@ModelAttribute LoginForm form, HttpSession session, Model model) {
		
		// Service
	    Teachers teachers = teachersService.login(form.getEmail(), form.getPassword());

	    if (teachers == null) {
	        // ログイン失敗
	        model.addAttribute("loginForm", new LoginForm());
	        model.addAttribute("error", "メールアドレス または パスワードが違います");
	        return "teacherLogin";
	    }
	    
	    //セッションに先生IDを保持
	    session.setAttribute("loginTeacher", teachers);
	    // ログイン成功
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session, Model model) {
		Teachers teacher = (Teachers) session.getAttribute("loginTeacher"); 
		
		if (teacher == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("teacher", teacher);
		
		return "dashboard";
	}
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Teachers;
import com.example.demo.form.TeachersNewForm;
import com.example.demo.helper.TeachersHelper;
import com.example.demo.service.TeachersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherController {
	
	//DI
	private final TeachersService teachersService;
	
	//トップ画面
	@GetMapping("/")
	public String showTop() {
		return "top";
	}
	
	//新規登録画面へ
	@GetMapping("/teacher/new")
	public String showNewTeacherForm(Model model) {
	    model.addAttribute("teachersNewForm", new TeachersNewForm());
	    return "teacherSetting";
	}
	
	//新規登録を実行
	@PostMapping("/teacher/new")
	public String registerTeachers(@ModelAttribute TeachersNewForm form ) {
		//entityへの変換
		Teachers teachers = TeachersHelper.convertTeachers(form);
		//登録を実行
		teachersService.insert(teachers);
        return "redirect:/login"; 
	}
	
	//ログイン画面
	@GetMapping("/login")
	public String showLogin() {
		return "teacherLogin";
	}
	
	
	//管理画面へ
	@PostMapping("/login")
	public String doLogin() {
		return "dashboard";
	}
	
	//新規登録画面へ
	@GetMapping("/test/new")
	public String showNewTestSetting() {
		return "testSetting";
	}
	
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
	
	//トップ画面
	@GetMapping("/")
	public String showTop() {
		return "top";
	}
	
	//新規登録画面へ
	@GetMapping("/teacher/new")
	public String showNewTeacherForm() {
		return "teacherSetting";
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

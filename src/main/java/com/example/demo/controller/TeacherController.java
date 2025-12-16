package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Teachers;
import com.example.demo.form.TeachersNewForm;
import com.example.demo.helper.TeachersHelper;
import com.example.demo.service.TeachersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class TeacherController {
	
	//DI
	private final TeachersService teachersService;
		
	//新規登録画面へ
	@GetMapping("/teacher")
	public String showNewTeacherForm(Model model) {
	    model.addAttribute("teachersNewForm", new TeachersNewForm());
	    return "register/teacherRegister";
	}
	
	//新規登録を実行
	@PostMapping("/teacher")
	public String registerTeachers(@Valid @ModelAttribute TeachersNewForm form,
	                               BindingResult result) {
		//入力エラー
		if (result.hasErrors()) {
	        return "register/teacherRegister"; 
	    }
		//entityへの変換
		Teachers teachers = TeachersHelper.convertTeachers(form);
		//登録を実行
		teachersService.insert(teachers);
        return "redirect:/login"; 
	}
	
}

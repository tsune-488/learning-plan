package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Students;
import com.example.demo.form.StudentsNewForm;
import com.example.demo.helper.StudentsHelper;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentSettingController {
	
	//DI
	private final StudentService studentService;
	
	//新規登録画面へ
	@GetMapping("/students/new")
	public String showNewStudentForm(
			@RequestParam("teacherId") Integer teacherId, Model model) {
		StudentsNewForm form = new StudentsNewForm();
        form.setIsNew(true); 
        form.setTeacherId(teacherId);
        
        model.addAttribute("studentsNewForm", form);
        return "studentSetting";
	}
	
	//新規登録を実行
	@PostMapping("/students/new")
	public String registerStudents(@ModelAttribute StudentsNewForm form ) {
		//entityへの変換
		Students students = StudentsHelper.convertStudents(form);
		//登録を実行
		studentService.insert(students);
		return "redirect:/students/login?teacherId=" + form.getTeacherId(); 
	}
	
}

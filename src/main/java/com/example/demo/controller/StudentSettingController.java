package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String showNewStudentForm(
	        HttpSession session,
	        Model model) {
		
		Integer testId = (Integer) session.getAttribute("testId");
		
		if (testId == null) {
	        return "redirect:/students/login";
	    }

		
		StudentsNewForm form = new StudentsNewForm();
        form.setIsNew(true); 
        form.setTestId(testId);
        
        model.addAttribute("studentsNewForm", form);
        return "studentSetting";
	}
	
	//新規登録を実行
	@PostMapping("/students/new")
	public String registerStudents(@ModelAttribute StudentsNewForm form,
			                       HttpSession session) {
		
		Integer testId = (Integer) session.getAttribute("testId");
		
		if (testId == null) {
	        return "redirect:/students/login";
	    }
		
		form.setTestId(testId);

		//entityへの変換
		Students students = StudentsHelper.convertStudents(form);
		//登録を実行
		studentService.registerStudent(students);
		
		return "redirect:/students/login";
	}
	
}

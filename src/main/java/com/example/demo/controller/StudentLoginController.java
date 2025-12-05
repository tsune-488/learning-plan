package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Students;
import com.example.demo.form.StudentLoginForm;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class StudentLoginController {
	
	//DI
	private final StudentService studentService;
	
	//ログイン画面
	@GetMapping("/students/login")
	public String showLogin(
			@RequestParam("teacherId") Integer teacherId,
			@RequestParam("testId") Integer testId,
			Model model) {
		
		//違うURLを使用した場合
		if (testId == null) {
	        model.addAttribute("msg", "先生から配布された新しいURLを使用してください。");
	        return "testIdError";
		}
		
		//テストIDと先生ID
		StudentLoginForm form = new StudentLoginForm();
		form.setTeacherId(teacherId);
		form.setTestId(testId);

		model.addAttribute("studentLoginForm", form);
	    return "studentLogin";
	}
	//ログイン処理
	@PostMapping("/students/login")
	public String doLogin(@ModelAttribute StudentLoginForm form, Model model) {
		
	    Students student = studentService.login(form.getStudentnumber(), form.getStudentpassword());

	    if (student == null) {
	        // ログイン失敗
	    	model.addAttribute("studentLoginForm", form);
	    	model.addAttribute("teacherId", form.getTeacherId());
	        model.addAttribute("error", "出席番号 または パスワードが違います");
	        return "studentLogin";
	    }

	 // ログイン後
	    return "redirect:/students/learning?studentId=" 
        + student.getId() 
        + "&testId=" + form.getTestId();
	}
}

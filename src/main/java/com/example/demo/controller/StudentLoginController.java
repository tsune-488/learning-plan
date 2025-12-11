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
import com.example.demo.service.StudentTestsService;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class StudentLoginController {
	
	//DI
	private final StudentService studentService;
	private final StudentTestsService studentTestsService;
	
	//ログイン画面
	@GetMapping("/students/login")
	public String showLogin(
			@RequestParam("teacherId") Integer teacherId,
			@RequestParam("testId") Integer testId,
			Model model) {
		
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
		
		Integer testId = form.getTestId();
		String studentNumber = form.getStudentnumber();
		String studentPassword = form.getStudentpassword();
		
		//testId
		if (testId == null) {
	        model.addAttribute("error", "ログイン方法が不正です。");
	        return "studentLogin";
	    }
		
		//生徒の検索
	    Students student = studentService.login(studentNumber, studentPassword);

		if (student == null) {
	        model.addAttribute("error", "番号またはパスワードが違います。");
	        model.addAttribute("studentLoginForm", form);
	        return "studentLogin";
	    }
		
		//studentId
		Integer studentId = student.getId();
		
		//学習計画期間に登録しているか
		if (!studentTestsService.isStudentInTest(studentId, testId)) {
	        model.addAttribute("error", "この学習期間には登録されていません。");
	        model.addAttribute("studentLoginForm", form);
	        return "studentLogin";
	    }
	

	 // ログイン後
	    return "redirect:/students/learning?studentId=" 
        + student.getId() 
        + "&testId=" + form.getTestId();
	}
}

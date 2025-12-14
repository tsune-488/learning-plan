package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String showLogin(HttpSession session, Model model) {

		
		//セッション
		Integer testId = (Integer) session.getAttribute("testId");
		
	    if (testId == null) {
	        return "redirect:/students/error"; 
	    }
		
		StudentLoginForm form = new StudentLoginForm();
	    form.setTestId(testId);

		model.addAttribute("studentLoginForm", form);
	    return "studentLogin";
	}
	//ログイン処理
	@PostMapping("/students/login")
	public String doLogin(@ModelAttribute StudentLoginForm form, 
			              HttpSession session,
			              Model model) {
		
		//セッション
		Integer testId = (Integer) session.getAttribute("testId");
	    
		if (testId == null) {
	        return "redirect:/students/error";
	    }
		
		//ログイン情報の照合
		Students student = studentService.login(
		            form.getStudentnumber(),
		            form.getStudentpassword(),
		            testId
		        );
		
		if (student == null) {
	        model.addAttribute("error", "番号またはパスワードが違います。");
	        model.addAttribute("studentLoginForm", form);
	        return "studentLogin";
	    }
		
		//この学習計画期間に登録されているか
		Integer studentId = student.getId();
		
		if (!studentTestsService.isStudentInTest(studentId, testId)) {
	        model.addAttribute("error", "この学習期間には登録されていません。");
	        model.addAttribute("studentLoginForm", form);
	        return "studentLogin";
	    }

		//セッションに保存
	    session.setAttribute("studentId", studentId);

	    return "redirect:/students/learning";
	}
}

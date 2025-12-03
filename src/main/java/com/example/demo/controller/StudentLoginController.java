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
	public String showLogin(@RequestParam("teacherId") Integer teacherId, Model model) {
		
		//違うURLを使用した場合
		if (teacherId == null) {
	        model.addAttribute("msg", "先生から配布されたURLを使用してください。");
	        return "teacherIdError";
		}
		
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentLoginForm", new StudentLoginForm());
	    return "studentLogin";
	}
	//ログイン処理
	@PostMapping("/students/login")
	public String doLogin(@ModelAttribute StudentLoginForm form, Model model) {
		
	    Students student = studentService.login(form.getStudentnumber(), form.getStudentpassword());

	    if (student == null) {
	        // ログイン失敗
	    	model.addAttribute("studentLoginForm", form);
	        model.addAttribute("error", "出席番号 または パスワードが違います");
	        return "studentLogin";
	    }

	 // ログイン後
	    return "redirect:/students/learning?studentId=" + student.getId();
	}
	
     // 学習記録入力ページ
     @GetMapping("/students/learning")
     public String showLearning(@RequestParam("studentId") Integer studentId, Model model) {
    	 model.addAttribute("studentId", studentId);   
    	 return "studentLearning"; 
     }
}

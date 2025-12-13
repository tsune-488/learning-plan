package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.form.StudentLoginForm;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class StudentTestController {

	// 生徒ページ
	@GetMapping("/test/{testId}/student")
	public String toStudentLogin(@PathVariable Integer testId, Model model) {

		StudentLoginForm form = new StudentLoginForm();
		form.setTestId(testId);

		model.addAttribute("studentLoginForm", form);
		return "studentLogin";
	}
}

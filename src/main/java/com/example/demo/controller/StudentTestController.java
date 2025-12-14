package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentTestController {

	// 生徒ページ
	@GetMapping("/test/{testId}/student")
	public String toStudentLogin(@PathVariable Integer testId,
			HttpSession session) {

		//セッションにtestIDを保存
		session.setAttribute("testId", testId);

		//ログイン画面へ
		return "redirect:/students/login";
	}
}

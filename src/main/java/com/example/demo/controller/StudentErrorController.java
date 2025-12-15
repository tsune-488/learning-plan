package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentErrorController {

	@GetMapping("/students/error")
	public String showStudentError() {
		return "student/studentError";
	}

}

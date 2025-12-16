package com.example.demo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.form.StudentsNewForm;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String handleUniqueConstraintViolation(
			DataIntegrityViolationException ex,
			Model model) {
		
		//エラーメッセージ
		model.addAttribute("error",
				"この出席番号は、すでに登録されています。");
		
		model.addAttribute("studentsNewForm", new StudentsNewForm());
		
		//登録画面に
		return "student/studentSetting";
	}

}

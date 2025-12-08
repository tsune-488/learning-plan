package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.TeacherClassListDto;
import com.example.demo.service.TeacherClassListService;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class TeacherTestListController {
	
	//DI
	private final TeacherClassListService teacherClassListService;
	
     // 生徒ページ
	 @GetMapping("/teacher/test/{testId}/students")
	    public String showClassList(@PathVariable Integer testId, Model model) {
		    
		    List<TeacherClassListDto> list = 
		    		teacherClassListService.selectClassListByTestId(testId);
		     
		    model.addAttribute("students", list);
	        
	        return "teacher/studentList"; 
	    }
	}

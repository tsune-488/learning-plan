package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TeacherCheckDto;
import com.example.demo.service.TeacherCheckService;
import com.example.demo.service.TeacherClassListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherCheckController {
	
	//DI
	private final TeacherCheckService teacherCheckService;
	private final TeacherClassListService teacherClassListService;
	
     // 生徒ページ
	 @GetMapping("/teacher/check")
	    public String showCheckList(
	    		@RequestParam("testId") Integer testId,
	    		@RequestParam("date") String date , Model model) {
		    
		    List<TeacherCheckDto> list = 
		    		teacherCheckService.selectCheckListByDaily(testId, date);
		    
		    model.addAttribute("list", list);
		    model.addAttribute("testId", testId);
		    model.addAttribute("date", date);
	        
	        return "teacher/dailycheck"; 
	    }
	}

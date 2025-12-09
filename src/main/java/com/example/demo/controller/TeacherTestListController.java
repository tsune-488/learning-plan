package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TestListDto;
import com.example.demo.service.TeacherTestListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherTestListController {
	
	//DI
	private final TeacherTestListService teacherTestListService;
	
     //テスト一覧
	 @GetMapping("/tests")
	    public String showTestList(Model model) {
		    
		    List<TestListDto> tests = 
		    		teacherTestListService.getAllTestList();
		     
		    model.addAttribute("tests", tests);
	        
	        return "teacher/testList"; 
	    }
	}

package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TeacherCheckDto;
import com.example.demo.entity.Teachers;
import com.example.demo.service.TeacherCheckService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherCheckController {
	
	//DI
	private final TeacherCheckService teacherCheckService;
	
     // 生徒ページ
	 @GetMapping("/teacher/check")
	    public String showCheckList(
	    		@RequestParam("testId") Integer testId,
	    		@RequestParam("date") String date , 
	    		HttpSession session,
	    		Model model) {
		 
		    Teachers teacher = (Teachers) session.getAttribute("loginTeacher");

		    if (teacher == null) {
	            return "redirect:/login";
	        }
		    
		    List<TeacherCheckDto> list = 
		    		teacherCheckService.selectCheckListByDaily(teacher.getId(), testId, date);
		    
		    model.addAttribute("list", list);
		    model.addAttribute("testId", testId);
		    model.addAttribute("date", date);
	        
	        return "teacher/dailycheck"; 
	    }
	}

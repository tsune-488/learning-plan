package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TeacherCheckDto;
import com.example.demo.security.TeacherUserDetails;
import com.example.demo.service.TeacherCheckService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherCheckController {
	
	// DI
		private final TeacherCheckService teacherCheckService;
		
		// 学習記録チェック画面
		@GetMapping("/teacher/check")
		public String showCheckList(
		        @RequestParam("testId") Integer testId,
		        @RequestParam("date") String date,
		        @AuthenticationPrincipal TeacherUserDetails userDetails,
		        Model model) {

		    List<TeacherCheckDto> list =
		            teacherCheckService.selectCheckListByDaily(
		                    userDetails.getTeacher().getId(),
		                    testId,
		                    date
		            );

		    model.addAttribute("list", list);
		    model.addAttribute("testId", testId);
		    model.addAttribute("date", date);

		    return "teacher/dailycheck";
		}
	}
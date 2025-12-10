package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TeacherClassListDto;
import com.example.demo.dto.TestListDto;
import com.example.demo.service.TeacherClassListService;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DateSelectController {
	
	//DI
	private final TeacherClassListService teacherClassListService;
	private final TestsService testsService;
	
	//日付選択画面
	 @GetMapping("/teacher/check/date")
	 public String showDateSelect(@RequestParam("testId") Integer testId, Model model) {
		 model.addAttribute("testId", testId);
		
		 List<TeacherClassListDto> students = teacherClassListService.selectClassListByTestId(testId);
		
		 //テスト期間の取得
		TestListDto test = testsService.getTestById(testId); 
		
		LocalDate start = test.getStartday();
		LocalDate end = test.getLastday();
		
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate current = start;
		
		while(!current.isAfter(end)) {
			dateList.add(current);
			current = current.plusDays(1);
		}
		 
		 model.addAttribute("testId", testId);
		 model.addAttribute("students", students);
		 model.addAttribute("dateList", dateList);
		 
		 return "teacher/dateSelect";
	 }
	 
}

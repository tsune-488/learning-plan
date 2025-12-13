package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TestListDto;
import com.example.demo.entity.Teachers;
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
	public String showTestList(HttpSession session,Model model) {

		// ログイン中の教員情報を取得
		Teachers teacher = (Teachers) session.getAttribute("loginTeacher");

		if (teacher == null) {
			return "redirect:/login";
		}
        
		//teacherID
		List<TestListDto> tests = teacherTestListService.getAllTestList(teacher.getId());

		model.addAttribute("tests", tests);

		return "teacher/testList";
	}
}

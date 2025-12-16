package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TeacherClassListDto;
import com.example.demo.dto.TestListDto;
import com.example.demo.entity.Teachers;
import com.example.demo.security.TeacherUserDetails;
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
	public String showDateSelect(@RequestParam("testId") Integer testId,
			@AuthenticationPrincipal TeacherUserDetails userDetails,
			Model model) {

		//ログイン中の教員情報を取得
		Teachers teacher = userDetails.getTeacher();
        Integer teacherId = teacher.getId();
		
		//教員ID と　テストID
		TestListDto test = testsService.getTestById(teacherId, testId);

		if (test == null) {
            return "redirect:/teacher/tests";
        }
		
		
		//生徒一覧
		List<TeacherClassListDto> students = teacherClassListService.selectClassListByTestId(testId);

		
		//テスト期間の取得
		LocalDate start = test.getStartday();
		LocalDate end = test.getLastday();

		List<LocalDate> dateList = new ArrayList<>();
	

		for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
            dateList.add(d);
        }


		model.addAttribute("testId", testId);
		model.addAttribute("students", students);
		model.addAttribute("dateList", dateList);

		return "teacher/dateSelect";
	}

}

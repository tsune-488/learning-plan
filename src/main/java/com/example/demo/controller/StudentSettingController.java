package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Students;
import com.example.demo.entity.TestsSetting;
import com.example.demo.form.StudentsNewForm;
import com.example.demo.helper.StudentsHelper;
import com.example.demo.service.StudentService;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentSettingController {

	//DI
	private final StudentService studentService;
	private final TestsService testsService;

	@GetMapping("/student/new")
	//新規登録画面へ
	public String showNewStudentForm(
			HttpSession session,
			Model model) {

		//セッション
		Integer testId = (Integer) session.getAttribute("testId");

		if (testId == null) {
			return "redirect:/students/error";
		}

		//新規登録用フォーム
		StudentsNewForm form = new StudentsNewForm();
		//新規か編集の判定
		form.setIsNew(true);
		//テストID取得
		form.setTestId(testId);

		model.addAttribute("studentsNewForm", form);
		return "studentSetting";
	}

	//新規登録を実行
	@PostMapping("/student/new")
	public String registerStudents(@ModelAttribute StudentsNewForm form,
			HttpSession session) {

		//セッション
		Integer testId = (Integer) session.getAttribute("testId");

		if (testId == null) {
			return "redirect:/students/error";
		}

		//testID から TestsSetting を取得
	    TestsSetting testSetting = testsService.findByIdForStudent(testId);
	    if (testSetting == null) {
	        return "redirect:/students/error";
	    }
		
	    //TestsSetting⇒teacherID を取得
	    form.setTestId(testId);
	    form.setTeacherId(testSetting.getTeacherId());

		//entityへの変換
		Students students = StudentsHelper.convertStudents(form);
		
		 // ☆確認テスト
	    System.out.println("form.teacherId=" + form.getTeacherId());
	    System.out.println("students.teacherId=" + students.getTeacherId());
		
		//登録を実行
		studentService.registerStudent(students);

		return "redirect:/students/login";
	}

}

package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

		model.addAttribute("studentsNewForm", form);
		return "studentSetting";
	}

	//新規登録を実行
	@PostMapping("/student/new")
	public String registerStudents(@ Valid @ModelAttribute StudentsNewForm form,
			                       BindingResult result,                       
			                       HttpSession session) {

		//入力エラー
		if (result.hasErrors()) {
	        return "studentSetting";
	    }
		
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
		
	    Integer teacherId = testSetting.getTeacherId();
	    
	    //Tentityへ変換
	    Students students = StudentsHelper.convertStudents(form);
	    students.setTestId(testId);
	    students.setTeacherId(teacherId);
		
		//登録を実行
		studentService.registerStudent(students);

		return "redirect:/students/login";
	}

}

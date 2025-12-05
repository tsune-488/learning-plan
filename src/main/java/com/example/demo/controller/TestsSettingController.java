package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.entity.TestsSetting;
import com.example.demo.form.TestsSettingForm;
import com.example.demo.helper.TestsSettingHelper;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestsSettingController {
	
	//DI
	private final TestsService testsService;

	
	//テスト登録画面へ
	@GetMapping("/test/new")
	public String showNewTestSettingForm(
			@SessionAttribute("teacherId") Integer teacherId,
			Model model) {
		TestsSettingForm form = new TestsSettingForm();
	    form.setTeacherId(teacherId);
	    model.addAttribute("testsSettingForm", form);
	    return "testSetting";
	}
	
	//テスト登録を実行
	@PostMapping("/test/new")
	public String registerTests(@ModelAttribute TestsSettingForm form , Model model) {
		//entityへの変換
		TestsSetting testsSetting = TestsSettingHelper.convertTestsSetting(form);
		//登録を実行
		testsService.insert(testsSetting);
		//連番の取得
		Integer testId = testsSetting.getId();
		Integer teacherId = form.getTeacherId(); 
		
		//生徒配布用のURLの生成
		String studentUrl = "/students/login?teacherId=" + teacherId + "&testId=" + testId;
		model.addAttribute("studentUrl", studentUrl);
		
	    return "studentUrlResult"; 
	}
	
	
}

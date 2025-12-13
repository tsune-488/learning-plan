package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Teachers;
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
			HttpSession session,
			Model model) {
		
		Teachers teacher = (Teachers) session.getAttribute("loginTeacher");
	    
		if (teacher == null) {
	        return "redirect:/login";
	    }
		
		TestsSettingForm form = new TestsSettingForm();
	    form.setTeacherId(teacher.getId());
	    
	    model.addAttribute("testsSettingForm", form);
	    return "testSetting";
	}
	
	//テスト登録を実行
	@PostMapping("/test/new")
	public String registerTests(@ModelAttribute TestsSettingForm form , 
			                    HttpSession session,
			                    Model model) {
		
		Teachers teacher = (Teachers) session.getAttribute("loginTeacher");
	    
		if (teacher == null) {
	        return "redirect:/login";
	    }
		
		form.setTeacherId(teacher.getId());
		
		//entityへの変換
		TestsSetting testsSetting = TestsSettingHelper.convertTestsSetting(form);
		//登録を実行
		testsService.insert(testsSetting);
		//連番の取得
		Integer testId = testsSetting.getId();
		
		//生徒配布用のURLの生成
		String studentUrl = "/test/" + testId + "/student";
		model.addAttribute("studentUrl", studentUrl);
		
	    return "studentUrlResult"; 
	}
	
	
}

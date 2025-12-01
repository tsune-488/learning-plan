package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String showNewTestSettingForm(Model model) {
		model.addAttribute("testsSettingForm",new TestsSettingForm());
		return "testSetting";
	}
	
	//テスト登録を実行
	@PostMapping("/test/new")
	public String registerTests(@ModelAttribute TestsSettingForm form ) {
		//entityへの変換
		TestsSetting testsSetting = TestsSettingHelper.convertTestsSetting(form);
		//登録を実行
		testsService.insert(testsSetting);
		
	    return "redirect:/dashboard"; 
	}
	
	
}

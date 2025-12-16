package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Teachers;
import com.example.demo.entity.TestsSetting;
import com.example.demo.form.TestsSettingForm;
import com.example.demo.helper.TestsSettingHelper;
import com.example.demo.security.TeacherUserDetails;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestsSettingController {

	//DI
	private final TestsService testsService;

	//テスト登録画面へ
	@GetMapping("/teacher/test/new")
	public String showNewTestSettingForm(
			@AuthenticationPrincipal TeacherUserDetails userDetails,
			Model model) {

		//教員のログイン情報を取得
		Teachers teacher = userDetails.getTeacher();

		TestsSettingForm form = new TestsSettingForm();
		form.setTeacherId(teacher.getId());

		model.addAttribute("testsSettingForm", form);
		return "teacher/testSetting";
	}

	//テスト登録を実行
	@PostMapping("/teacher/test/new")
	public String registerTests(@Valid @ModelAttribute TestsSettingForm form,
			BindingResult result,
			@AuthenticationPrincipal TeacherUserDetails userDetails,
			Model model) {

		//教員のログイン情報を取得
		Teachers teacher = userDetails.getTeacher();

		//開始日＜終了日のチェック
		if (form.getStartday() != null &&
				form.getLastday() != null &&
				form.getStartday().isAfter(form.getLastday())) {
			result.rejectValue("lastday", null, "終了日は開始日以降にしてください");
		}

		//入力チェックエラー
		if (result.hasErrors()) {
			return "teacher/testSetting";
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

		return "teacher/studentUrlResult";
	}

}

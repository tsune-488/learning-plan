package com.example.demo.helper;

import com.example.demo.entity.TestsSetting;
import com.example.demo.form.TestsSettingForm;

//新規登録のヘルパー
public class TestsSettingHelper {
	//TestsSttingへの変換
	public static TestsSetting convertTestsSetting(TestsSettingForm form) {
		
		TestsSetting testsSetting = new TestsSetting();
		testsSetting.setId(form.getId());
		testsSetting.setTestname(form.getTestname());
		testsSetting.setStartday(form.getStartday());
		testsSetting.setLastday(form.getLastday());
        
		return testsSetting;
	}
		
	//TestsSettingFormへの変換
	public static TestsSettingForm convertTestsSettingForm(TestsSetting testsSetting) {
		
		TestsSettingForm testsSettingForm = new TestsSettingForm();
		testsSettingForm.setId(testsSetting.getId());
		testsSettingForm.setTestname(testsSetting.getTestname());
		testsSettingForm.setStartday(testsSetting.getStartday());
		testsSettingForm.setLastday(testsSetting.getLastday());
        
		//更新画面設定
		testsSettingForm.setIsNew(false);
		return testsSettingForm;
	}
}

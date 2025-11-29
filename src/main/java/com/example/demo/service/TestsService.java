package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TestsSetting;

public interface TestsService {
	
	//登録情報の取得
	List<TestsSetting> findAll();
	
	//IDから登録された設定情報を取得
	TestsSetting findById(Integer id);
		
	//設定情報を登録
	void insert(TestsSetting testsSetting);
	
	//設定情報の更新
	void update(TestsSetting testsSetting);

}

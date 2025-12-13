package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TestListDto;
import com.example.demo.entity.TestsSetting;

public interface TestsService {
	
	//登録情報の取得
	List<TestListDto> getAllTests(Integer teacherId);
	
	//学習計画期間の取得
	TestListDto getTestById(Integer teacherId, Integer testId);

	//生徒用の学習計画期間の取得
	TestsSetting findByIdForStudent(Integer testId);
	
	//設定情報を登録
	void insert(TestsSetting testsSetting);
	
	//設定情報の更新
	void update(TestsSetting testsSetting);
	
	
}

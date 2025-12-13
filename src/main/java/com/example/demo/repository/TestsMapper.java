package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.TestListDto;
import com.example.demo.entity.TestsSetting;

@Mapper
public interface TestsMapper {

	//テスト一覧を取得
	List<TestListDto> findAllTests(@Param("teacherId") Integer teacherId);

	//学習期間の取得
	TestListDto selectTestById(@Param("teacherId") Integer teacherId,
			                   @Param("testId") Integer testId);

	//生徒用の学習計画期間の取得
	TestsSetting findByIdForStudent(@Param("testId") Integer testId);
	
	//設定情報を登録
	void insert(TestsSetting testsSetting);

	//設定情報の更新
	void update(TestsSetting testsSetting);
}

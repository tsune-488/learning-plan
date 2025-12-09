package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.TestListDto;
import com.example.demo.entity.TestsSetting;

@Mapper
public interface TestsMapper {
	//登録情報の取得
	List<TestsSetting> findAll();
	
	//IDから登録された設定情報を取得
	TestsSetting findById(@Param("id") Integer id);
	
	//設定情報を登録
	void insert(TestsSetting testsSetting);
	
	//設定情報の更新
	void update(TestsSetting testsSetting);
	
	//テスト一覧を取得
	List<TestListDto> findAllForTeacher();

}

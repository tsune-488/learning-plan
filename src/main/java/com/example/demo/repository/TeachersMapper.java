package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Teachers;

@Mapper
public interface TeachersMapper {
	//登録情報の取得
	List<Teachers> selectAll();
	
	//設定情報を登録
	void insert(Teachers teachers);
	
	//設定情報の更新
	void update(Teachers teachers);

}

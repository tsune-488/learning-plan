package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Teachers;

@Mapper
public interface teachersMapper {
	//登録情報の取得
	List<Teachers> selectAll();
	
	//IDから登録された設定情報を取得
	Teachers selectById(@Param("id") Integer id);
	
	//設定情報を登録
	void insert(Teachers teachers);
	
	//設定情報の更新
	void update(Teachers teachers);

}

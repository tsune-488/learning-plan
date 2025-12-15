package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Teachers;

@Mapper
public interface TeachersMapper {
	//登録情報の取得
	List<Teachers> selectAll();
	
	//設定情報を登録
	void insert(Teachers teachers);
	
	//設定情報の更新
	void update(Teachers teachers);
	
	//ログイン情報の照合
	Teachers findByEmailAndPassword(@Param("email") String email, 
			                        @Param("password") String password);
	
	//先生email
	Teachers findByEmail(String email);

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teachers;

public interface TeachersService {
	 //登録情報の取得
	List<Teachers> selectAll();
		
	//設定情報を登録
	void insert(Teachers teachers);
		
	//設定情報の更新
	void update(Teachers teachers);
	
	//ログイン情報の照合
	Teachers login(String email, String password);

}

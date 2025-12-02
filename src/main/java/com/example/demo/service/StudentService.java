package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Students;

public interface StudentService {
	 //登録情報の取得
	List<Students> selectAll();
		
	//設定情報を登録
	void insert(Students students);
		
	//設定情報の更新
	void update(Students students);
	
	//ログイン情報の照合
	Students login(String studentNmber, String studentPassword);
}

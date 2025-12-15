package com.example.demo.service;

import com.example.demo.entity.Students;

public interface StudentService {
	
	//設定情報を登録
	void insert(Students students);
		
	//設定情報の更新
	void update(Students students);
	
	//ログイン情報の照合
    Students login(String studentNumber, String studentPassword, Integer testId);
	
	//studentIDとtestIDの連携
	void registerStudent(Students student);
}

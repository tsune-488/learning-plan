package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Students;

public interface StudentService {
	//クラスの登録情報を取得
	List<Students> selectByTeacherId(Integer teacherId);

	//設定情報を登録
	void insert(Students students);
		
	//設定情報の更新
	void update(Students students);
	
	//ログイン情報の照合
	Students login(String studentNumber, String studentPassword, Integer testId);
}

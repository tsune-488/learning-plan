package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LearningRecord;

public interface LearningRecordService {
	
	//計画内容および実施内容すべての検索
	List<LearningRecord> findAll();
		
	//IDから登録された情報を取得
	LearningRecord findById(Integer id);
		
	//計画内容および実施内容の登録
	void insert(LearningRecord learningRecord);
		
	//計画内容および実施内容の更新
	void update(LearningRecord learningRecord);
	
	//再掲載用
	List<LearningRecord> findByStudentAndTest(Integer studentId, Integer testId);
}

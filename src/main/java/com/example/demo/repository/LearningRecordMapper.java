package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.LearningRecord;

@Mapper
public interface LearningRecordMapper {
	//計画内容および実施内容すべての検索
	List<LearningRecord> findAll();
	
	//IDから登録された情報を取得
	LearningRecord findById(@Param("id") Integer id);
	
	//計画内容および実施内容の登録
	void insert(LearningRecord learningRecord);
	
	//計画内容および実施内容の更新
	void update(LearningRecord learningRecord);
}

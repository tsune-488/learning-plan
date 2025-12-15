package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Students;

@Mapper
public interface StudentsMapper {
	//登録情報の取得
	List<Students> selectByTeacherId(@Param("teacherId")Integer teacherId);
	
	//設定情報を登録
	void insert(Students students);
	
	//設定情報の更新
	void update(Students students);
	
	//ログイン情報の照合
	Students findByStudentnumberAndTestId(
		    @Param("studentnumber") String studentnumber,
		    @Param("testId") Integer testId);
}

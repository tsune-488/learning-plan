package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentTestsMapper {
	//その学習期間に登録されている生徒か
	boolean existsByStudentAndTest(@Param("studentId") Integer studentId,
			                        @Param("testId") Integer testId);
	
	//登録
	void insert(@Param("studentId") Integer studentId,
                @Param("testId") Integer testId);

}

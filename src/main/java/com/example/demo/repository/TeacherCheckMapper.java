package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.TeacherCheckDto;

@Mapper
public interface TeacherCheckMapper {
	//日付とテストIDでチェック一覧を取得
	List<TeacherCheckDto> selectCheckListByDaily(
			@Param("testId") Integer testId,
			@Param("date") String date);
}

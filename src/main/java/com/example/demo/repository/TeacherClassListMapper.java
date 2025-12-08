package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TeacherClassListDto;

@Mapper
public interface TeacherClassListMapper {
	//登録情報の取得
	List<TeacherClassListDto> selectClassListByTestId(Integer testId);
}

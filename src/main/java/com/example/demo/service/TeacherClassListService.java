package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TeacherClassListDto;

public interface TeacherClassListService {
	
	List<TeacherClassListDto> selectClassListByTestId(Integer testId);
}

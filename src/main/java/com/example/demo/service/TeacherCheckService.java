package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TeacherCheckDto;

public interface TeacherCheckService {
	
	List<TeacherCheckDto> selectCheckListByDaily(Integer teacherId,Integer testId,String date);
}

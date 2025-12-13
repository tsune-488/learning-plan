package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TeacherCheckDto;
import com.example.demo.repository.TeacherCheckMapper;
import com.example.demo.service.TeacherCheckService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class TeacherCheckServiceImpl implements TeacherCheckService {

	//DI
	private final TeacherCheckMapper teacherCheckMapper;
	
	@Override
	public List<TeacherCheckDto> selectCheckListByDaily(Integer teacherId,Integer testId, String date){
		return teacherCheckMapper.selectCheckListByDaily(teacherId ,testId, date);
	}
}


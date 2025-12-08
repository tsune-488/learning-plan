package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TeacherClassListDto;
import com.example.demo.repository.TeacherClassListMapper;
import com.example.demo.service.TeacherClassListService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class TeacherClassListServiceImpl implements TeacherClassListService {

	//DI
	private final TeacherClassListMapper teacherClassListMapper;
	
	@Override
	public List<TeacherClassListDto> selectClassListByTestId(Integer testId) {
		return teacherClassListMapper.selectClassListByTestId(testId);
	}
}


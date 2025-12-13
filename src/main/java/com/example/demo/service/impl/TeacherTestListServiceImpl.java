package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TestListDto;
import com.example.demo.repository.TestsMapper;
import com.example.demo.service.TeacherTestListService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class TeacherTestListServiceImpl implements TeacherTestListService {

	//DI
	private final TestsMapper testsMapper;
	
	@Override
	public List<TestListDto> getAllTestList(Integer teacherId) {
		return testsMapper.findAllTests(teacherId);
	}
}


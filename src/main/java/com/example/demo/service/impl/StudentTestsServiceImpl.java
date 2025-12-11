package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.StudentTestsMapper;
import com.example.demo.service.StudentTestsService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentTestsServiceImpl implements StudentTestsService {

	//DI
	private final StudentTestsMapper studentTestsMapper;
	
	@Override
	public boolean isStudentInTest(Integer studentId, Integer testId) {
	    return studentTestsMapper.existsByStudentAndTest(studentId, testId);
	}
	
}


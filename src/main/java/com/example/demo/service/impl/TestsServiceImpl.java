package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TestListDto;
import com.example.demo.entity.TestsSetting;
import com.example.demo.repository.TestsMapper;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TestsServiceImpl implements TestsService {
	
	//DI
	private final TestsMapper testsMapper;

	@Override
    public List<TestListDto> getAllTests(Integer teacherId) {
        return testsMapper.findAllTests(teacherId);
    }
	
	@Override
	public TestListDto getTestById(Integer teacherId, Integer testId) {
		return testsMapper.selectTestById(teacherId, testId);
	}
	
	@Override
	public TestsSetting findByIdForStudent(Integer testId) {
	    return testsMapper.findByIdForStudent(testId);
	}
	
	@Override
	public void insert(TestsSetting testsSetting) {
		testsMapper.insert(testsSetting);
	}

	@Override
	public void update(TestsSetting testsSetting) {
		testsMapper.update(testsSetting);
	}
	
	

}

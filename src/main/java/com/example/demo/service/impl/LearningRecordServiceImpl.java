package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.LearningRecord;
import com.example.demo.repository.LearningRecordMapper;
import com.example.demo.service.LearningRecordService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LearningRecordServiceImpl implements LearningRecordService {
	
	//DI
	private final LearningRecordMapper learningRecordMapper;

	@Override
	public List<LearningRecord> findAll() {
		return learningRecordMapper.findAll();
	}
	
	@Override
	public List<LearningRecord> findByStudentAndTest(Integer studentId, Integer testId) {
		return learningRecordMapper.findByStudentAndTest(studentId, testId);
	}

	@Override
	public LearningRecord findById(Integer id) {
		return learningRecordMapper.findById(id);
	}

	@Override
	public void insert(LearningRecord learningRecord) {
		learningRecordMapper.insert(learningRecord);
	}

	@Override
	public void update(LearningRecord learningRecord) {
		learningRecordMapper.update(learningRecord);
	}

}

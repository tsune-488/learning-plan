package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentMapper;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	//DI
	private final StudentMapper studentMapper;
	
	@Override
	public List<Students> selectAll() {
		return studentMapper.selectAll();
	}

	@Override
	public void insert(Students students) {
		studentMapper.insert(students);
	}

	@Override
	public void update(Students students) {
		studentMapper.update(students);
	}
	
	@Override
	public Students login(String studentNumber, String studentPassword) {
		return studentMapper.findByNumberAndPassword(studentNumber, studentPassword);
	}
}


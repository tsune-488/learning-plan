package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentsMapper;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	//DI
	private final StudentsMapper studentsMapper;
	
	@Override
	public List<Students> selectByTeacherId(Integer teacherId) {
		return studentsMapper.selectByTeacherId(teacherId);
	}

	@Override
	public void insert(Students students) {
		studentsMapper.insert(students);
	}

	@Override
	public void update(Students students) {
		studentsMapper.update(students);
	}
	
	//@Override
	//public Students login(String studentNumber, String studentPassword, Integer testId) {
	//	return studentsMapper.findByNumberAndPassword(studentNumber, studentPassword, testId);
	//}
	
	@Override
	public void registerStudent(Students student) {
		studentsMapper.insert(student);
	}
}


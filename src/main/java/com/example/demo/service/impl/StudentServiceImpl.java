package com.example.demo.service.impl;

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
	public void insert(Students students) {
		studentsMapper.insert(students);
	}

	@Override
	public void update(Students students) {
		studentsMapper.update(students);
	}
	
	@Override
	public Students login(String studentNumber, String studentPassword, Integer testId) {
		Students student =
		        studentsMapper.findByStudentnumberAndTestId(studentNumber, testId);

		if (student == null) {
			return null;
		}

		// パスワード照合
		if (!student.getStudentpassword().equals(studentPassword)) {
			return null;
		}

		return student;
	}
	
	@Override
	public void registerStudent(Students student) {
		studentsMapper.insert(student);
	}
}


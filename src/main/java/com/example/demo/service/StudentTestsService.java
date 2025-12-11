package com.example.demo.service;

public interface StudentTestsService {
	//その学習期間にその生徒が登録しているか
	boolean isStudentInTest(Integer studentId, Integer testId);
}

package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearningRecord {

	// ID
	private Integer id;
	//生徒ID
	private Integer studentId;
	//試験ID
	private Integer testId;
	// 学習日
	private LocalDate learnDay; 
	//学習計画内容
	private String plan;
	//実施した学習内容
	private String record;
}
package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearningRecordForm {
	
	// ID
	private Integer id;
	//生徒ID
	private Integer studentId;
	//試験ID
	private Integer testId;
	// 学習日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate learnDay; 
	//学習計画内容
	private String plan;
	//実施した学習内容
	private String record;
	//新規判定
    private Boolean isNew;

}

package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherClassListDto {
	//生徒ID
	private Integer studentId;
	//試験ID
	private Integer testId;
	//試験名
	private String testName;
	// 出席番号
    private String studentNumber;
    //生徒名 
    private String studentName; 
}

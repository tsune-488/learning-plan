package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCheckDto {
	//生徒ID
	private Integer studentNumber;
	//生徒名
	private String studentName;
	//学習計画
	private String plan;
	//実施内容
	private String record;
}

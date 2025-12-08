package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherClassListDto {
	//生徒ID
	private Integer studentid;
	//試験ID
	private Integer testId;
	// 出席番号
    private String studentnumber;
    //生徒名 
    private String studentname; 
}

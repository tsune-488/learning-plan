package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsNewForm {
	//テストのID
	private Integer testId;
	// 出席番号
	private String studentnumber;
	//生徒名 
	private String studentname;
	// パスワード
	private String studentpassword;
	//新規判定
	private Boolean isNew;
}

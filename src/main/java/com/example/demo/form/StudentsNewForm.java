package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsNewForm {
	
	// 出席番号
	@NotBlank(message = "出席番号を入力してください")
	private String studentnumber;
	//生徒名
	@NotBlank(message = "名前を入力してください")
	private String studentname;
	// パスワード
	@NotBlank(message = "パスワードを入力してください")
    @Size(min = 4, max = 20, message = "パスワードは4〜20文字で入力してください")
	private String studentpassword;
	//新規判定
	private Boolean isNew;
}

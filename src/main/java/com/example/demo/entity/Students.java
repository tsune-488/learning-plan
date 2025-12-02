package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    // ID
	private Integer teacher_id;
	// 出席番号
	@NotBlank(message="出席番号は必須です")
    private String studentnumber;
    //生徒名 
	@NotBlank(message="名前は必須です")
    private String studentname; 
    // パスワード
	@NotBlank(message="パスワードは必須です")
    private String studentpassword;
}


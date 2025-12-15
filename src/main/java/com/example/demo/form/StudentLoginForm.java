package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginForm {
    // 出席番号
	@NotBlank(message = "登録した出席番号を入力してください")
    private String studentnumber; 
    // パスワード
	@NotBlank(message = "パスワードを入力してください")
    private String studentpassword;
    
    // テストID
    private Integer testId;
}

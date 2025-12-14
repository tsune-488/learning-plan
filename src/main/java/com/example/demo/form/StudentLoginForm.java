package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	@NotNull(message = "テスト情報が不正です。最初からやり直してください")
    private Integer testId;
}

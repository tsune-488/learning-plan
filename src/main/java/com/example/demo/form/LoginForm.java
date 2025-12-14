package com.example.demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    // メールアドレス
	@Email(message = "メールアドレスの形式が正しくありません")
	@NotBlank(message = "登録したメールアドレスを入力してください")
    private String email; 
    // パスワード
	@NotBlank(message = "パスワードを入力してください")
    private String password;
}

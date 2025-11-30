package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    // メールアドレス
    private String email; 
    // パスワード
    private String password;
}

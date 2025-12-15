package com.example.demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachersNewForm {
	//IDは自動登録のため、入っていません
	// 学校名
	@NotBlank(message = "学校名を入力してください")
    private String schoolname;
    // メールアドレス
	@Email(message = "メールアドレスの形式が正しくありません")
	@NotBlank(message = "メールアドレスを入力してください")
    private String email; 
    // パスワード
	@NotBlank(message = "パスワードを入力してください")
    @Size(min = 4, max = 20, message = "パスワードは4〜20文字で入力してください")
    private String password;
    // 学年クラス
	@NotBlank(message = "学年・クラスを入力してください")
    private String classname;
    // 先生の名前
	@NotBlank(message = "登録する先生のお名前を入力してください")
    private String teachername;  
	//新規判定
    private Boolean isNew;

}

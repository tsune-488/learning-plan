package com.example.demo.form;

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
    private String schoolname;
    // メールアドレス
    private String email; 
    // パスワード
    private String password;
    // 学年クラス
    private String classname;
    // 先生の名前
    private String teachername;  
	//新規判定
    private Boolean isNew;

}

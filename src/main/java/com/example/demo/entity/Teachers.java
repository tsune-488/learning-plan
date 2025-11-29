package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teachers {

    // ID
	private Integer id;
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
}


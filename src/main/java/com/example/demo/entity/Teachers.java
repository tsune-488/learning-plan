package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;

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
	@NotBlank(message="学校名は必須です")
    private String schoolname;
    // メールアドレス
	@NotBlank(message="メールアドレスは必須です")
    private String email; 
    // パスワード
	@NotBlank(message="パスワードは必須です")
    private String password;
    // 学年クラス
	@NotBlank(message="学年・クラスは必須です")
    private String classname;
    // 先生の名前
	@NotBlank(message="先生の名前は必須です")
    private String teachername;
}


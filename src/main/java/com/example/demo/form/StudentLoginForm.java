package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginForm {
    // 出席番号
    private String studentnumber; 
    // パスワード
    private String studentpassword;
    
    // テストID
    private Integer testId;
}

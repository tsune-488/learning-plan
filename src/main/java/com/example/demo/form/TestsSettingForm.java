package com.example.demo.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ToDOフォーム
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestsSettingForm {
	
	// ID
	private Integer id;
	// テスト名
	private String testname;
	// 開始日
	private LocalDate startday; 
	// 終了日
	private LocalDate lastday;
	//先生ID
	private Integer teacherId;
	//新規判定
    private Boolean isNew;

}

package com.example.demo.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@NotBlank(message = "試験名を入力してください")
	private String testname;
	// 開始日
	@NotNull(message = "学習計画期間が始まる日を選択してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startday; 
	// 終了日
	@NotNull(message = "学習計画期間が終わる日を選択してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastday;
	//先生ID
	private Integer teacherId;
	//新規判定
    private Boolean isNew;

}

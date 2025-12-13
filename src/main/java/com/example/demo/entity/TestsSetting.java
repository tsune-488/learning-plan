package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestsSetting {

    // ID
	private Integer id;
	//先生ID
	@NotBlank(message="先生IDは必須です")
	private Integer teacherId;
	// テスト名
	@NotBlank(message="テスト名は必須です")
    private String testname;
    // 開始日
	@NotNull(message="開始日は必須です")
    private LocalDate startday; 
    // 終了日
	@NotNull(message="終了日は必須です")
    private LocalDate lastday;
}
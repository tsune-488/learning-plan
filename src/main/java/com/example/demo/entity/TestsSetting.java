package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestsSetting {

    // ID
	private Integer id;
	// 学校名
    private String testname;
    // 開始日
    private LocalDate startday; 
    // 終了日
    private LocalDate lastday;
}
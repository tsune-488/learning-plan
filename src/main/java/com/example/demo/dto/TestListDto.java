package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestListDto {
	//試験ID
	private Integer id;
	//試験名
	private String testName;
	//開始日
	private LocalDate startday;
	//最終日
	private LocalDate lastday;
}

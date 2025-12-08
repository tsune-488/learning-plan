package com.example.demo.helper;

import com.example.demo.dto.TeacherClassListDto;
import com.example.demo.entity.Students;

//新規登録のヘルパー
public class TeacherClassListHelper {
	//Studentsへの変換
	public static Students toStudentsEntity(TeacherClassListDto dto) {
		
		Students students = new Students();
		students.setTeacherId(dto.getId());
		students.setStudentnumber(dto.getStudentnumber());
		students.setStudentname(dto.getStudentname());
        
		return students;
	}
		
	//TeacherClassListDtoへの変換
	public static TeacherClassListDto toTeacherClassListDto(Students students) {
		
		TeacherClassListDto teacherClassListDto = new TeacherClassListDto();
		teacherClassListDto.setId(students.getId());
		teacherClassListDto.setStudentnumber(students.getStudentnumber());
		teacherClassListDto.setStudentname(students.getStudentname());
		
		return teacherClassListDto;
	}
}

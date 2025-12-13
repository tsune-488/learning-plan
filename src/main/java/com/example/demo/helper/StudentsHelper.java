package com.example.demo.helper;

import com.example.demo.entity.Students;
import com.example.demo.form.StudentsNewForm;

//新規登録のヘルパー
public class StudentsHelper {
	//Studentsへの変換
	public static Students convertStudents(StudentsNewForm form) {
		
		Students students = new Students();

		students.setTestId(form.getTestId());
		students.setStudentnumber(form.getStudentnumber());
		students.setStudentname(form.getStudentname());
		students.setStudentpassword(form.getStudentpassword());
        
		return students;
	}
		
	//StudentsNewFormへの変換
	public static StudentsNewForm convertStudentsNewForm(Students students) {
		
		StudentsNewForm studentsNewForm = new StudentsNewForm();
		studentsNewForm.setTestId(students.getTestId());
		studentsNewForm.setStudentnumber(students.getStudentnumber());
		studentsNewForm.setStudentname(students.getStudentname());
		studentsNewForm.setStudentpassword(students.getStudentpassword());
		
		
		//更新画面設定
		studentsNewForm.setIsNew(false);
		return studentsNewForm;
	}
}

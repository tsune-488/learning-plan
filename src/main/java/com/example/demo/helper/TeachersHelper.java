package com.example.demo.helper;

import com.example.demo.entity.Teachers;
import com.example.demo.form.TeachersNewForm;

//新規登録のヘルパー
public class TeachersHelper {
	//Teachersへの変換
	public static Teachers convertTeachers(TeachersNewForm form) {
		
		Teachers teachers = new Teachers();
		teachers.setSchoolname(form.getSchoolname());
		teachers.setEmail(form.getEmail());
		teachers.setPassword(form.getPassword());
		teachers.setClassname(form.getClassname());
		teachers.setTeachername(form.getTeachername());
        
		return teachers;
	}
		
	//TeachersNewFormへの変換
	public static TeachersNewForm convertTeachersNewForm(Teachers teachers) {
		
		TeachersNewForm teachersNewForm = new TeachersNewForm();
		teachersNewForm.setSchoolname(teachers.getSchoolname());
		teachersNewForm.setEmail(teachers.getEmail());
		teachersNewForm.setPassword(teachers.getPassword());
		teachersNewForm.setClassname(teachers.getClassname());
		teachersNewForm.setTeachername(teachers.getTeachername());
        
		//更新画面設定
		teachersNewForm.setIsNew(false);
		return teachersNewForm;
	}
}

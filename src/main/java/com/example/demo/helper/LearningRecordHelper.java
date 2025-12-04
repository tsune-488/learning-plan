package com.example.demo.helper;

import com.example.demo.entity.LearningRecord;
import com.example.demo.form.LearningRecordForm;

//新規登録のヘルパー
public class LearningRecordHelper {
	//LearningRecordへの変換
	public static LearningRecord convertLearningRecordS(LearningRecordForm form) {
		
		LearningRecord learningRecord = new LearningRecord();
		learningRecord.setId(form.getId());
		learningRecord.setStudentId(form.getStudentId());
		learningRecord.setTestId(form.getTestId());
		learningRecord.setLearnDay(form.getLearnDay());
		learningRecord.setPlan(form.getPlan());
		learningRecord.setRecord(form.getRecord());
        
		return learningRecord;
	}
		
	//LearningRecordFormへの変換
	public static LearningRecordForm convertLearningRecordForm(LearningRecord learningRecord) {
		
		LearningRecordForm learningRecordForm = new LearningRecordForm();
		learningRecordForm.setId(learningRecord.getId());
		learningRecordForm.setStudentId(learningRecord.getStudentId());
		learningRecordForm.setTestId(learningRecord.getTestId());
		learningRecordForm.setLearnDay(learningRecord.getLearnDay());
		learningRecordForm.setPlan(learningRecord.getPlan());
		learningRecordForm.setRecord(learningRecord.getRecord());
		
		//更新画面設定
		learningRecordForm.setIsNew(false);
		return learningRecordForm;
	}
}

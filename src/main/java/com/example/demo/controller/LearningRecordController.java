package com.example.demo.controller;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LearningRecord;
import com.example.demo.service.LearningRecordService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LearningRecordController {
	
	//DI
	private final LearningRecordService learningRecordService;
	
	//学習結果と実施内容の登録を実行
	@PostMapping("/student/save")
	public String registerLeaningRecord(
			@RequestParam Integer studentId,
			@RequestParam Integer testId,
			HttpServletRequest request,
			Model model) {
		
		//１１日～１６日まで登録
		for (int day = 11; day <= 16; day++) {
			
			//HTMLの名前に合わせる
		    String plan = request.getParameter("plan_" + day);
		    String record = request.getParameter("record_" + day);
		    //空なら保存しない
		    if ((plan == null || plan.isBlank()) && (record == null || record.isBlank())) {
		        continue;
		    }
		    
		    LearningRecord learningRecord = new LearningRecord();
		
		    learningRecord.setStudentId(studentId);
		    learningRecord.setTestId(testId);
		    learningRecord.setLearnDay(LocalDate.of(2025, 12, day));
		    learningRecord.setPlan(plan);
		    learningRecord.setRecord(record);
		
		    //保存
		    learningRecordService.insert(learningRecord);
	    }
	
	    model.addAttribute("msg", "保存しました");
        return "redirect:/students/learning?studentId=" + studentId + "&testId=" + testId; 
	}
	
	@GetMapping("/students/learning")
	public String showLearning(
	        @RequestParam Integer studentId,
	        @RequestParam Integer testId,
	        Model model) {

	    model.addAttribute("studentId", studentId);
	    model.addAttribute("testId", testId);

	    return "studentLearning";
	}

}

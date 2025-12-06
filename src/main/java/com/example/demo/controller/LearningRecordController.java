package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LearningRecord;
import com.example.demo.entity.TestsSetting;
import com.example.demo.service.LearningRecordService;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LearningRecordController {
	
	//DI
	private final LearningRecordService learningRecordService;
	private final TestsService testsService;
	
	//学習結果と実施内容の登録を実行
	@PostMapping("/student/save")
	public String registerLeaningRecord(
			@RequestParam Integer studentId,
			@RequestParam Integer testId,
			HttpServletRequest request,
			Model model) {
		
		// テスト期間を取得
	    TestsSetting testDay = testsService.findById(testId);
	    LocalDate start = testDay.getStartday();
	    LocalDate end = testDay.getLastday();
	        
	    // 日付期間を作成
	    List<LocalDate> dateList = new ArrayList<>();
	    LocalDate today = start;
	    while (!today.isAfter(end)) {
	    	dateList.add(today);
	    	today = today.plusDays(1);
	    }
	    
		
		//１１日～１６日まで登録
		for (LocalDate date: dateList) {
			
			//HTMLの名前に合わせる
		    String plan = request.getParameter("plan_" + date);
		    String record = request.getParameter("record_" + date);
		    //空なら保存しない
		    if ((plan == null || plan.isBlank()) && (record == null || record.isBlank())) {
		        continue;
		    }
		    
		    LearningRecord learningRecord = new LearningRecord();
		
		    learningRecord.setStudentId(studentId);
		    learningRecord.setTestId(testId);
		    learningRecord.setLearnDay(date);
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
		
		//テストの日程の取得
		TestsSetting testDay =  testsService.findById(testId);
		LocalDate start = testDay.getStartday();
		LocalDate end = testDay.getLastday();
		
		//学習記録期間の日程作成
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate toDay = start;
		while(!toDay.isAfter(end)) {
			dateList.add(toDay);
			toDay = toDay.plusDays(1);
		}
		
		List<LearningRecord> records = learningRecordService.findByStudentAndTest(studentId, testId);

	    model.addAttribute("studentId", studentId);
	    model.addAttribute("testId", testId);
	    model.addAttribute("dateList", dateList);
	    model.addAttribute("records", records);

	    return "studentLearning";
	}

}

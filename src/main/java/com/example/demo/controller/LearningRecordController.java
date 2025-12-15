package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
			HttpServletRequest request,
			HttpSession session,
			Model model) {

		// セッションから取得
		Integer studentId = (Integer) session.getAttribute("studentId");
		Integer testId = (Integer) session.getAttribute("testId");

		if (studentId == null || testId == null) {
			return "redirect:/students/error";
		}

		// テスト期間を取得
		TestsSetting testDay = testsService.findByIdForStudent(testId);
		LocalDate start = testDay.getStartday();
		LocalDate end = testDay.getLastday();

		// 日付期間を作成
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate today = start;
		while (!today.isAfter(end)) {
			dateList.add(today);
			today = today.plusDays(1);
		}

		//登録されてデータの取得
		List<LearningRecord> existingRecords = learningRecordService.findByStudentAndTest(studentId, testId);

		Map<LocalDate, LearningRecord> existingMap = new HashMap<>();
		for (LearningRecord record : existingRecords) {
			if (record.getLearnDay() != null) {
				existingMap.put(record.getLearnDay(), record);
			}
		}
		//設定された学習期間の日付を登録
		for (int i = 0; i < dateList.size(); i++) {
			LocalDate date = dateList.get(i);

			//HTMLの名前に合わせる
			String plan = request.getParameter("plan_" + i);
			String record = request.getParameter("record_" + i);
			//空なら保存しない
			if ((plan == null || plan.isBlank()) && (record == null || record.isBlank())) {
				continue;
			}

			//生徒IDと照合し、データを取得
			LearningRecord learningRecord = new LearningRecord();

			learningRecord.setStudentId(studentId);
			learningRecord.setTestId(testId);
			learningRecord.setLearnDay(date);
			learningRecord.setPlan(plan);
			learningRecord.setRecord(record);

			//保存
			if (existingMap.containsKey(date)) {
				learningRecord.setId(existingMap.get(date).getId());
				learningRecordService.update(learningRecord);
			} else {
				learningRecordService.insert(learningRecord);
			}

		}

		model.addAttribute("msg", "保存しました");
		return "redirect:/students/learning";
	}

	@GetMapping("/students/learning")
	public String showLearning(HttpSession session, Model model) {

		//セッションから取得
		Integer studentId = (Integer) session.getAttribute("studentId");
		Integer testId = (Integer) session.getAttribute("testId");

		if (studentId == null || testId == null) {
			return "redirect:/students/error";
		}

		//テストの日程の取得
		TestsSetting testDay = testsService.findByIdForStudent(testId);
		LocalDate start = testDay.getStartday();
		LocalDate end = testDay.getLastday();

		//学習記録期間の日程作成
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate toDay = start;
		while (!toDay.isAfter(end)) {
			dateList.add(toDay);
			toDay = toDay.plusDays(1);
		}

		//学習記録取得
		List<LearningRecord> records = learningRecordService.findByStudentAndTest(studentId, testId);

		//日付から記録のMapを作る
		Map<LocalDate, LearningRecord> recordMap = new HashMap<>();
		for (LearningRecord r : records) {
			if (r.getLearnDay() != null) {
				recordMap.put(r.getLearnDay(), r);
			}
		}

		//リスト化
		List<LearningRecord> viewList = new ArrayList<>();
		for (LocalDate d : dateList) {
			viewList.add(recordMap.getOrDefault(d, null));
		}

		model.addAttribute("studentId", studentId);
		model.addAttribute("testId", testId);
		model.addAttribute("dateList", dateList);
		model.addAttribute("viewList", viewList);

		return "student/learning";
	}
}

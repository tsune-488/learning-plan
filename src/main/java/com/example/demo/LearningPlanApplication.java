package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.TeachersService;
import com.example.demo.service.TestsService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@MapperScan("com.example.demo.repository")
@RequiredArgsConstructor
public class LearningPlanApplication implements CommandLineRunner {

    private final TeachersService teachersService;
    private final TestsService testsService;

    public static void main(String[] args) {
        SpringApplication.run(LearningPlanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===== TeachersService 動作確認 =====");
        System.out.println(teachersService.selectAll());

        System.out.println("===== TestsService 動作確認 =====");
        System.out.println(testsService.findAll());
    }
}
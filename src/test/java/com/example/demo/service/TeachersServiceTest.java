package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Teachers;

@SpringBootTest
class TeachersServiceTest {

    @Autowired
    TeachersService teachersService;

    @Test
    void testSelectAll() {
        // 実行
        List<Teachers> list = teachersService.selectAll();

        // 確認
        System.out.println(list);
        assertThat(list).isNotNull();
    }

    @Test
    void testInsert() {
        Teachers t = new Teachers();
        t.setTeachername("テスト先生");
        t.setEmail("test@test.com");
        t.setPassword("pass");
        t.setSchoolname("テスト学校");
        t.setClassname("1-1");

        teachersService.insert(t);
    }
}
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Teachers;
import com.example.demo.service.TeachersService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class TeachersServiceImpl implements TeachersService {

	@Override
	public List<Teachers> selectAll() {
		return selectAll();
	}

	@Override
	public void insert(Teachers teachers) {
	}

	@Override
	public void update(Teachers teachers) {
	}

}

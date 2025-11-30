package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Teachers;
import com.example.demo.repository.TeachersMapper;
import com.example.demo.service.TeachersService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class TeachersServiceImpl implements TeachersService {

	//DI
	private final TeachersMapper teachersMapper;
	
	@Override
	public List<Teachers> selectAll() {
		return teachersMapper.selectAll();
	}

	@Override
	public void insert(Teachers teachers) {
		teachersMapper.insert(teachers);
	}

	@Override
	public void update(Teachers teachers) {
		teachersMapper.update(teachers);
	}
	
	@Override
	public Teachers login(String email, String password) {
		return teachersMapper.findByEmailAndPassword(email, password);
	}
}

package com.example.demo.security;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teachers;
import com.example.demo.repository.TeachersMapper;

@Service
@Primary
public class TeacherUserDetailsService implements UserDetailsService {

    private final TeachersMapper teachersMapper;

    public TeacherUserDetailsService(TeachersMapper teachersMapper) {
        this.teachersMapper = teachersMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

    	System.out.println("★★ loadUserByUsername: " + email);
    	
    	Teachers teacher = teachersMapper.findByEmail(email);

        if (teacher == null) {
            throw new UsernameNotFoundException("Teacher not found: " + email);
        }

        return new TeacherUserDetails(teacher);
    }
}
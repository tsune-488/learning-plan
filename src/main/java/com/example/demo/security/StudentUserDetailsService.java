package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentsMapper;

//@Service
public class StudentUserDetailsService implements UserDetailsService {

    private final StudentsMapper studentsMapper;
    private final HttpServletRequest request;
    
    public StudentUserDetailsService(
            StudentsMapper studentsMapper,
            HttpServletRequest request) {
        this.studentsMapper = studentsMapper;
        this.request = request;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
    	//username = 出席番号
        String studentnumber = username;
        
        //hidden で送られてくる testId を取得
        String testIdStr = request.getParameter("testId");
        if (testIdStr == null) {
            throw new UsernameNotFoundException("testId is required");
        }
        
        Integer testId = Integer.valueOf(testIdStr);

        Students student = studentsMapper.findByStudentnumberAndTestId(studentnumber, testId);

        if (student == null) {
            throw new UsernameNotFoundException("Student not found: " + username);
        }

        return new StudentUserDetails(student);
    }
}
    

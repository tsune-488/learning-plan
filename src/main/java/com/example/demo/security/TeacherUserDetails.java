package com.example.demo.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Teachers;

public class TeacherUserDetails implements UserDetails {

    private final Teachers teacher;

    public TeacherUserDetails(Teachers teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getUsername() {
        return teacher.getEmail();
    }

    @Override
    public String getPassword() {
        return teacher.getPassword();
    }
    
    public Teachers getTeacher() {
        return teacher;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
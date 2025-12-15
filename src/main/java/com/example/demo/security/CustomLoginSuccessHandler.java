package com.example.demo.security;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities =
                authentication.getAuthorities();

        //教員の場合
        if (authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"))) {
            response.sendRedirect("/teacher/home");
            return;
        }

        //生徒の場合
        if (authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
            response.sendRedirect("/student/home");
            return;
        }

        //どちらでもない場合
        response.sendRedirect("/login?error");
    }
}
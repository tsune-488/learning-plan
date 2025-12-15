package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.security.CustomLoginSuccessHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//DI
	private final CustomLoginSuccessHandler customLoginSuccessHandler;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(
								"/",
								"/css/**",
								"/js/**",
								"/images/**",
								"/login",
								"/student/login",
								"/teacher/new" )
						.permitAll()
						 .requestMatchers("/teacher/**").hasRole("TEACHER")
						.anyRequest().authenticated())
				.formLogin(form -> form
					    .loginPage("/login") // 教員のログイン
					    .loginProcessingUrl("/login") // 教員用
					    .successHandler(customLoginSuccessHandler)
					    .failureUrl("/login?error")
					)
				.logout(logout -> logout
						.logoutSuccessUrl("/login?logout"))
				.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

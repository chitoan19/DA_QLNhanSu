//package com.tttn.quanlynhansu.security;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.csrf().ignoringAntMatchers("/api/**");
//		http.cors();
//		http.authorizeRequests()
////			.antMatchers("/css/**").permitAll()
////			.antMatchers("/fonts/**").permitAll()
////			.antMatchers("/images/**").permitAll()
////			.antMatchers("/js/**").permitAll()
//			.antMatchers("/api/**").permitAll();
//			
//	}
//
//}

package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.AdminInterceptor;

//@Configuration
public class AdminInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/notece/insert")
		.addPathPatterns("/notice/update")
		.addPathPatterns("/notice/delete");
	}
}

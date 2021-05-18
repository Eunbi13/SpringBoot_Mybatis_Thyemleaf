package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.SecondInterceptor;
@Configuration
public class SecondInterceptorConfig implements WebMvcConfigurer{
	@Autowired
	private SecondInterceptor secondInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(secondInterceptor)
				.addPathPatterns("/**")
				.order(0);//순서 정하는 것 0에 가까울수록 우선순위가 높다
	}
}

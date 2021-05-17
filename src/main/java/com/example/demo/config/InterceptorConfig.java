package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.TestInterceptor;
@Configuration//설정파일입니다 xml대신
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private TestInterceptor testInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 적용할 인터셉터 Bean을 등록하는 과정, 어떤 URL이 왔을 때 인터셉터를 발동할 건지 설정
		registry.addInterceptor(testInterceptor) //test인터셉터가 인터셉터다. 
		.addPathPatterns("/notice/**");//루트 설정 
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}

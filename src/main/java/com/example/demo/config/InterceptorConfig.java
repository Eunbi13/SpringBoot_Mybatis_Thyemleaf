package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.AdminInterceptor;
import com.example.demo.interceptor.TestInterceptor;
//@Configuration //설정파일입니다 xml대신
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private TestInterceptor testInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 적용할 인터셉터 Bean을 등록하는 과정, 어떤 URL이 왔을 때 인터셉터를 발동할 건지 설정
		 //여러개 등록 가능 또는 컨피그 파일을 또 만들어도 됨
		registry.addInterceptor(testInterceptor) //test인터셉터가 인터셉터다. 추가해라 testIntercepter이다
		
		//.addPathPatterns("/notice/**")//루트 설정 //이 test~~가 어떤 url이 왔을 때 실행할 것이냐
		.addPathPatterns("/qna/**");
		
		//exclue Interceptor에서 제외할 url등록
		//.excludePathPatterns("/notice/select");
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}

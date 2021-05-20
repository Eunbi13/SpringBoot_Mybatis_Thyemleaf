package com.example.demo.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer{
	
	//레지스터리에 등록하는 거 하나 로케일 위치 판단 하나 (인터퓨ㅔ이스 타입)
	@Bean
	public LocaleResolver localeResolver() {
		//session을 사용하여 설정 서버 저장
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREA);
		//쿠키를 사용하여 설정할 때 클라이언트 저장
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREA);
		cookieLocaleResolver.setCookieName("lang");//cookie에서 꺼낼때 키벨류 형식
		
		return cookieLocaleResolver;//세선과 쿠키 중 하나 리턴 
	}
	
	//Interceptor 
	//라이브러리로 이미 만들어진 걸 사용할 거다
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		//파라미터를 받아서 언어 구분 url?lang=en
		
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor())
				.addPathPatterns("/**");
	}
}

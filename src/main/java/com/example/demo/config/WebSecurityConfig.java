package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//암호화용
	@Bean
	public PasswordEncoder passwordEncoder()throws Exception{
		
		return new BCryptPasswordEncoder();
	}
	
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		//시큐리티 제외할것 무시할것
		web.ignoring()
		.antMatchers("/resources/**")
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/vendor/**")
		.antMatchers("/favicon/**")
		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 세부설정(url에 따른 로그인 유무, 권한 유무)
		http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/member/join").permitAll()
				.antMatchers("/member/delete").hasRole("MEMBER")
				.antMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
				.antMatchers("/notice/list", "/notice/select").permitAll()
				.antMatchers("/notice/**").hasRole("ADMIN")
				.antMatchers("/qna/list", "/qna/select").permitAll()
				.antMatchers("/qna/**").hasAnyRole("ADMIN","MEMBER")
				.anyRequest().authenticated()
			.and()
			//and()쓰기 싫으면 그냥 http.formLogin()이렇게 가도 된다 그냥 문단이라고 보기 "메서드 체이닝"
			.formLogin()
			//개발자가 작성한 로그인 페이지를 따로 만들지 않아도 기본 내장된 폼으로 이동을 함
			//만약 만들어둔 페이지가 있어서 따로 쓰려면 아래와 같이 입력
				.loginPage("/member/login")
				.defaultSuccessUrl("/member/memberLoginResult")//성공하면 갈곳 
				//이게 무슨 의미냐면 로그인 성공했을 때의 경우를 개발자가 지정하는 것이 아니라 
				//스프링이 알아서 해주는데 컨트롤러에 만들어둠
				.permitAll()
			.and()
//			.logout()
			;
		
		//작성자 아이디와 로그인 아이디가 같은지에 대한건 인터셉터에서 적용하는 것
		//인증 권한 등 로그인과 관련된 것들만 가능
	}
}

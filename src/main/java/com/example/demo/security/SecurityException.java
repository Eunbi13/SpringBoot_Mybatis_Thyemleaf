package com.example.demo.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

//로그인 성공 후에 권한 에러가 발생했을 때 실행되는 핸들러
public class SecurityException implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		RequestDispatcher view = request.getRequestDispatcher("");
//		request.setAttribute("key","value");
//		view.forward(request, response);
		
		//어떤 작업가능
		response.sendRedirect("/member/error");
	}
}

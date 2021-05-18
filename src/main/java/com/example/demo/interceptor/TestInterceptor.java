package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.MemberVO;
//@Component
public class TestInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("컨트롤러 진입전 실행 ");
		// TODO Auto-generated method stub
//		HttpSession session= request.getSession();//작게 사는거에서 오래 사는거 가져오기 가능 반대는 불가능
//		Object obj=session.getAttribute("member");
//		MemberVO memberVO = null;
//		boolean result = false;
//		if(obj != null) {//로그인 완료됨
//			memberVO = (MemberVO)obj;
//			if(memberVO.getUserName().equals("admin")) {
//				result = true;
//			}
//		}
//		
//		if(!result) {
//			response.sendRedirect("/member/login");
//		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("컨트롤러 종료 후");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("클라이언트 전송 전");
	}
}

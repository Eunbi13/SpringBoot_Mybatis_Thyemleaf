package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.member.MemberVO;
@Component
public class TestInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();//작게 사는거에서 오래 사는거 가져오기 가능 반대는 불가능
		Object obj=session.getAttribute("member");
		MemberVO memberVO = null;
		boolean result = false;
		if(obj != null) {//로그인 완료됨
			memberVO = (MemberVO)obj;
			if(memberVO.getUserName().equals("admin")) {
				result = true;
			}
		}
		
		if(!result) {
			response.sendRedirect("/member/login");
		}
		
		return result;
	}
}

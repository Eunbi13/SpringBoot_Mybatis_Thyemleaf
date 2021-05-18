package com.example.demo.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.member.MemberVO;
//@Component
public class AdminInterceptor implements HandlerInterceptor{
	//어드민만 들어갈수있는 url
	//controller 진입전에 어드민인지 판별
	//어드민이면 진행하고 아니면 
	//로그인 폼으로 리다이렌트
	//성공시에 메세지 띄우기 권한이 없습니다.alert 확인 누르면 index로 이동
	//포워드로 보낼려고 
	//request.setAttrivute("name","data");
	//RequestDispatcher view = request.getRequestDispatcher("경로");
	//view.forward(request,response);
	//
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//page 객체 			/--/			
		//request객체		/----/			
		//session객체		/------/		
		//application객체	/--------/		
		//객체의 크기가 큰쪽에서는 작은 쪽이 만들어진지 아닌지 모름
		//하지만 생명주기가 짧은 쪽에서는 
		//생성되었단 것 자체가 큰 쪽이 만들어져있다는 이야기임
		
		
		
		System.out.println("프리핸들 시작 ");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		System.out.println("preHandle 종료");
		
		boolean result = false;
		
		if(memberVO !=null && memberVO.getUserName().equals("admin")) {
			result=true;
		}else {
			request.setAttribute("msg", "관리자가 아님");
			request.setAttribute("path","../member/login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../common/result");
			dispatcher.forward(request, response);
			//response.sendRedirect("/member/login");
		}
		
		return result;
	}
}

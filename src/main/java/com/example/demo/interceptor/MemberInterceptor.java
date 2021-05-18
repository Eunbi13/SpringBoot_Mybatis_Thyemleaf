package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.member.MemberMapper;
import com.example.demo.member.MemberVO;

@Component
public class MemberInterceptor implements HandlerInterceptor{
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		
		// post 컨트롤러 들어가기 전에 검사해야함
		String method = request.getMethod();
		if(method.equals("post")) {
			String userName=request.getParameter("userName");
			MemberVO memberVO = new MemberVO();
			memberVO.setUserName(userName);
			Long count =memberMapper.getUserName(memberVO);
			
			if(count==0) {
				result = true;
			}
		}
		return result;
	}
}

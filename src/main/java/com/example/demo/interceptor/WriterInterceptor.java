package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.BoardVO;
import com.example.demo.member.MemberVO;
@Component
public class WriterInterceptor implements HandlerInterceptor{
	//로그인해서 글 수정할때 글 작성자랑 로그인한 사람 유저네임이 일치하는지 
	//아니라면 alert창 후 리스트
	
	
	//컨트롤러 종료 후 실행
	//작성자를 출력
	//로그인 유저 네임 출력
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("after controller ----");
		HttpSession session =request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		
		BoardVO boardVO=(BoardVO)modelAndView.getModel().get("vo");
		
		System.out.println("writer: "+boardVO.getWriter());
		System.out.println(memberVO.getUserName());
		
	}
	//writerInterceptorConfig에 등록
	///qna/update주소가 들어왔을 때
}

package com.example.demo.interceptor;

import javax.servlet.RequestDispatcher;
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
		System.out.println("----after controller");
		
		//0. method 형식 
		String method = request.getMethod();
		if(method.equals("GET")) {
			this.check(request, modelAndView);
		}
		
	}
	//파라미터 보내는 방법
	
	
	//writerInterceptorConfig에 등록
	///qna/update주소가 들어왔을 때
	
	
	
	private void check(HttpServletRequest request, ModelAndView modelAndView) {

		HttpSession session =request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		
		BoardVO boardVO=(BoardVO)modelAndView.getModel().get("vo");
		
		
		//로그인을 하지 않았다면 common/result msg: 로그인이 필요하다 member/login이동
		if(memberVO!=null && boardVO !=null) {//로그인 여부
			System.out.println("writer: "+boardVO.getWriter());
			System.out.println("userName: "+memberVO.getUserName());
			
			if(! boardVO.getWriter().equals( memberVO.getUserName()) ) {//일치하는지 여부
				modelAndView.setViewName("common/result");
				modelAndView.addObject("msg", "작성자가 아닙니다.");
				modelAndView.addObject("path","./list");
			}
		
		}else {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("msg", "로그인이 필요합니다.");
			modelAndView.addObject("path","../member/login");
		}
		
		//유저와 작성자 일치하는지 체크하기
		//아닐경우 common/result	msg:작성자가 아닙니다 list로 이동
		//if(boardVO.getWriter()!=memberVO.getUserName())
		System.out.println("after controller ----");
	}
	
	
	
}

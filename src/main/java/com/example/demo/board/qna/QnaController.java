package com.example.demo.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@ModelAttribute("board")//뭐든지 얘가 제일 먼저 실행됨 //속성의 이름
	public String getBoard() {
		return "qna";//벨류값
	}
	
	@GetMapping("list")
	public String getList( )throws Exception{
		//model.addAttribute("name", "QNA"); //이렇게 넣을 필요 없이 저 위의 Model이 실행된다는 것
		return "board/list";
	}
}

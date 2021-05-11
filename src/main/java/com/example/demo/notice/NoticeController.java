package com.example.demo.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.board.BoardVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")//속성의 이름
	public String getBoard() {
		return "notice";//벨류값
	}
	@GetMapping("list")
	public String getList(Model model)throws Exception{
		List<BoardVO> ar = noticeService.getList();
		model.addAttribute("list", ar);
		return "board/list";
	}
}

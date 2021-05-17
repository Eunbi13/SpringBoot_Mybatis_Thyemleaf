package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.board.BoardVO;
/**
 * =====================
	Thymeleaf 프로젝트입니다
 * =====================
*/
@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		//model.addAttribute("message", "Thymeleaf project");
	
		return "index";
	}
}

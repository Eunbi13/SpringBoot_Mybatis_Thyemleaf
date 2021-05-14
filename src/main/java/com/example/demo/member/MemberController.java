package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("join")
	public String setJoin()throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("join")
	public String setJoin(MemberVO memberVO, MultipartFile file)throws Exception{
		service.setJoin(memberVO, file);
		return "redirect:../";
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/memberLogin";
	}
	
	@PostMapping("login")
	public String getLogin(MemberVO memberVO)throws Exception{
		service.getLogin(memberVO);
		return "redirect:../";
	}
	
	@GetMapping("page")
	public String getMyPage() throws Exception{
		return "/member/memberPage";
	}
	
	@GetMapping("logout")
	public String logout() throws Exception{
		
		return "/";
	}
	
}

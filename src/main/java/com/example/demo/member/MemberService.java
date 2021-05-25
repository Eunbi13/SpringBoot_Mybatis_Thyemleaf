package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileManager;

@Service
//spring security에서 사용하는 service
//UserDetailsService
public class MemberService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		mapper.getLogin(memberVO);
		return null;
	}

	//검증 메서드
	public boolean memberError(MemberVO memberVO, Errors errors)throws Exception{
		boolean result=false;
		
		//기본 제공 검증 결과
//		if(errors.hasErrors()) {
//			result=true;
//		}
		result = errors.hasErrors();
		
		//검증 코드 만들기
		//password가 일치하는가?
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			errors.rejectValue("passwordCheck", "memberVO.password.notEqual");
							  //form path||field	properties에 적은 키
			result=true;//에러 발생하면 트루
		}
		
		if(mapper.checkUserName(memberVO)>0) {
			errors.rejectValue("userName", "memberVO.userName.has");
		}
		
		//회워가입하러 올때 admin, adminstrator 로 가입하려는 거 막기
		if(memberVO.getUsername().equals("admin")||memberVO.getUsername().equals("adminstrator")) {
			errors.rejectValue("userName", "memberVO.userName.nope");
		}
		
		
		return result;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Long setJoin(MemberVO memberVO, MultipartFile file) throws Exception{
		
		Long result = mapper.setJoin(memberVO);
		if(result<1) {
			throw new Exception();
		}
		if(file.getSize() !=0) {//size로 하면 되는구나
			FileManager fileManager = new FileManager();
			String path = "upload/member/";
			String fileName = fileManager.save(file, path);
			MemberFileVO fileVO = new MemberFileVO();
			fileVO.setUserName(memberVO.getUsername());
			fileVO.setFileName(fileName);
			fileVO.setOriName(file.getOriginalFilename());
			mapper.setMemberFile(fileVO);
		}
		return result;
	}
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return mapper.getLogin(memberVO);
	}
	
	

}

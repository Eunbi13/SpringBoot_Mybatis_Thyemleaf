package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	@Transactional(rollbackFor = Exception.class)
	public Long setJoin(MemberVO memberVO, MultipartFile file) throws Exception{
		
		Long result = mapper.setJoin(memberVO);
		if(result<1) {
			throw new Exception();
		}
		FileManager fileManager = new FileManager();
		String path = "/upload/member/";
				
		String fileName = fileManager.save(file, path);
		//파일 넘겨주는 작업 필요 그리고 마이페이지 작업하면 끝
		return result;
	}
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return mapper.getLogin(memberVO);
	}
	
	public MemberVO getMyPage(MemberVO memberVO)throws Exception{
		return mapper.getMyPage(memberVO);
	}

}

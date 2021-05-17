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
		if(file.getSize() !=0) {//size로 하면 되는구나
			FileManager fileManager = new FileManager();
			String path = "upload/member/";
			String fileName = fileManager.save(file, path);
			MemberFileVO fileVO = new MemberFileVO();
			fileVO.setUserName(memberVO.getUserName());
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

package com.example.demo.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public Long setJoin(MemberVO memberVO)throws Exception;
	public Long setMemberFile(MemberFileVO memberFileVO)throws Exception;
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	public MemberVO getMyPage(MemberVO memberVO) throws Exception;
}

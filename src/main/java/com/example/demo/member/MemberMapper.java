package com.example.demo.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public Long setJoin(MemberVO memberVO)throws Exception;
	public int setMemberRole(Map<String, String> map)throws Exception;
	public Long checkUserName(MemberVO memberVO)throws Exception;
	public Long setMemberFile(MemberFileVO memberFileVO)throws Exception;
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
}

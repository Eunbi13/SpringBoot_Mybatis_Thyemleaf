package com.example.demo.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberMapperTest {
	@Autowired
	private MemberMapper mapper;
	
	//@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("id2");
		memberVO.setPassword("id2");
		memberVO.setName("id2");
		memberVO.setPhone("01033333333");
		memberVO.setEmail("id2@id2");
		memberVO.setEnabled(true);
		
		Long result = mapper.setJoin(memberVO);
		assertEquals(1, result);
	}
	
	//@Test
	void setMemberRoleTest() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", "id2");
		map.put("roleName", "MEMBER");
	int result=	mapper.setMemberRole(map);
	assertEquals(1, result);
	}
	
	@Test
	void getMemberLogin() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("id2");
		
		memberVO = mapper.getLogin(memberVO);
		for(RoleVO roleVO: memberVO.getRoles()) {
			System.out.println(roleVO.getRoleName());
			
		}
		assertNotNull(memberVO);
		
	}
}

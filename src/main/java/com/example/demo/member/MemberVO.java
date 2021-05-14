package com.example.demo.member;

import lombok.Data;

@Data
public class MemberVO {
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	private MemberFileVO file;
}

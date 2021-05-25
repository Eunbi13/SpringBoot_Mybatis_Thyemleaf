package com.example.demo.member;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Data;

//스프링 시큐리티에서 사용하는 전용VO가 있다.
//개발자가 UserDetails 클래스를 생성&상속하던가 MemberVO에서 상속 받도록 한다.
@Data
public class MemberVO implements UserDetails{//memberVO는 userDetailes 타입이 되었다.

	private String username;
	
	@Length(max = 10, min=4)
	private String password;
	
	private String passwordCheck;
	
	@NotEmpty
	private String name;
	private String email;
	private String phone;
	

	private boolean enabled;
	//Role
	private List<RoleVO> roles;

	//Role저장
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//무슨 타입이든 상관 없지만 GrantedAuthority타입이여야한다.
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(RoleVO roleVO: this.roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}

package com.java.mib.maccount.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.java.mib.maccount.model.dao.MemberInfoDao;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired 
	private MemberInfoDao memberInfoDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		CustomUserDetails users = memberInfoDao.getUserById();
		if(users == null) {
			throw new UsernameNotFoundException(username + "을 찾을수 없습니다.");
		}
		System.out.println("++++++++++++++++++++++");
		System.out.println("id : " + users.getUsername());
		return users;
		
	}
}

package com.java.mib.maccount.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.mib.maccount.model.dao.MemberInfoDao;
import com.java.mib.maccount.model.dao.MemberInfoImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired 
	private MemberInfoImpl memberInfoImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		CustomUserDetails users = memberInfoImpl.getUserById(username);
		if(users == null) {
			System.out.println(username + ": 없음");
			throw new UsernameNotFoundException(username + "을 찾을수 없습니다.");
		}
		System.out.println("++++++++++++++++++++++");
		System.out.println("id : " + users.getUsername());
		return users;
		
	}
}

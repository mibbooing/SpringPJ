package com.java.mib.maccount.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.mib.maccount.security.CustomUserDetails;

@Repository
public class MemberInfoImpl {
	@Autowired 
	MemberInfoDao memberInfoDao;
	
	public CustomUserDetails getUserById(String userid) {
		return memberInfoDao.getUserById(userid);
	}
	
	
}

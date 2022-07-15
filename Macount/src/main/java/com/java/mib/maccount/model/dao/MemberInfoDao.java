package com.java.mib.maccount.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.java.mib.maccount.security.CustomUserDetails;

@Repository
@Mapper
public interface MemberInfoDao {
	List<Map<String, Object>> getMemberInfoData();
	
	CustomUserDetails getUserById();
}

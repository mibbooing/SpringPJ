package com.java.mib.maccount.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.mib.maccount.model.dao.MemberInfoDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberInfoDao memberInfoDao;
	
	@Override
	public List<Map<String, Object>> getMemberInfoData(){
		return memberInfoDao.getMemberInfoData();
	}
}

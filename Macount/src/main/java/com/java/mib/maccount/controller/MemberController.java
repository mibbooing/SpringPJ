package com.java.mib.maccount.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.mib.maccount.security.CustomUserDetails;
import com.java.mib.maccount.security.CustomUserDetailsService;
import com.java.mib.maccount.service.MemberService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class MemberController {
	@Autowired MemberService memberService;
	@Autowired CustomUserDetailsService userDetailService;
	
	@GetMapping("/login")
	public ModelAndView loginGet(ModelAndView model) {
		model.setViewName("member/login");
		return model;
	}
	
	@PostMapping("/login")
	public String loginPost(CustomUserDetails requestUserInfo) {
		userDetailService.loadUserByUsername(requestUserInfo.getUsername());
		return "redirect:/home";
	}
	
	@GetMapping("/signup")
	public ModelAndView signupGet(ModelAndView model) {
		model.setViewName("member/signup");
		return model;
	}
	
	@PostMapping("/signup")
	public ModelAndView signupPost(ModelAndView model) {
		model.setViewName("member/login");
		return model;
	}
	
	
}

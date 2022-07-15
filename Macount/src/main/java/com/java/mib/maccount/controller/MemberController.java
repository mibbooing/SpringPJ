package com.java.mib.maccount.controller;


import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@RequestParam String userid,@RequestParam String password ) {
		userDetailService.loadUserByUsername(userid);
		return "/home";
	}
	
	@GetMapping("/signup")
	public ModelAndView signupGet(ModelAndView model) {
		model.setViewName("member/signup");
		return model;
	}
	
	@PostMapping("/signup")
	public String signupPost(HttpServletRequest request) {
		System.out.println("POST"+request.getAttribute("userid"));
		return "signup";
	}
	
}

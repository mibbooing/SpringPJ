package com.java.mib.maccount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
	@GetMapping("/home")
	public ModelAndView loginGet(ModelAndView model) {
		model.setViewName("/home");
		return model;
	}
}

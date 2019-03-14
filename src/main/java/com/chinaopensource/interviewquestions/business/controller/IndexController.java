package com.chinaopensource.interviewquestions.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String getUser(Model model) {
		model.addAttribute("user", "测试");
		return "index";
	}
}
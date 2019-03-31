package com.chinaopensource.interviewquestions.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate ;
	
	@GetMapping("/")
	public String getUser(Model model) {
		model.addAttribute("user", "测试");
		redisTemplate.opsForValue().set("liqiwei", "liqiwei");
		return "index";
	}
}
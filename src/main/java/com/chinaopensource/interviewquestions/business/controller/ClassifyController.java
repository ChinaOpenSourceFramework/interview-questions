package com.chinaopensource.interviewquestions.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaopensource.interviewquestions.business.data.Classify;
import com.chinaopensource.interviewquestions.business.service.ClassifyService;
import com.chinaopensource.interviewquestions.common.controller.BaseResponse;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/classify")
public class ClassifyController {

	@Autowired
	private ClassifyService classifyService;
	
	@GetMapping("/toAdd")
	public String toAddClassify(Model model) {
		model.addAttribute("classify", new Classify());
		return "classify/addClassify";
	}
	
	@PostMapping("/save")
	public String saveClassify(Classify classify) {
		classifyService.save(classify);
		return "classify/classifyList";
	}
	
	@GetMapping("/toUpdate")
	public String toUpdateClassify(Model model,Integer id) {
		model.addAttribute("classify", classifyService.selectById(id));
		return "classify/addClassify";
	}
	
	@GetMapping("/toClassifyList")
	public String toClassifyList(Model model) {
		return "classify/classifyList";
	}
	
	@GetMapping("/classifyList")
	@ResponseBody
	public String classifyList(@RequestParam(required=false,defaultValue="0")Integer pageNum, @RequestParam(required=false,defaultValue="10")Integer pageSize) {
		PageInfo<Classify> data = classifyService.selectByQuery(pageNum, pageSize);
		return BaseResponse.successJson(data);
	}
}
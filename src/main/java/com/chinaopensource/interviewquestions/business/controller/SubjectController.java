package com.chinaopensource.interviewquestions.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaopensource.interviewquestions.business.data.Subject;
import com.chinaopensource.interviewquestions.business.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/toAdd")
	public String toAddSubject(Model model) {
		return "subject/addSubject";
	}
	
	@PostMapping("/save")
	public String saveSubject(Subject subject) {
		subjectService.save(subject);
		return "subject/addSubject";
	}
}
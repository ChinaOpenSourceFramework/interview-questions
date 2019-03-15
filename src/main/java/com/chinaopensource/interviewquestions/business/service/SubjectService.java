package com.chinaopensource.interviewquestions.business.service;

import com.chinaopensource.interviewquestions.business.data.Subject;

public interface SubjectService {

	public void save(Subject subject);
	
	public void delete(Integer id);
	
	public Subject selectById(Integer id);
}

package com.chinaopensource.interviewquestions.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaopensource.interviewquestions.business.data.Subject;
import com.chinaopensource.interviewquestions.business.mapper.SubjectMapper;
import com.chinaopensource.interviewquestions.business.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
	
	@Override
	public void save(Subject subject) {
		if(subject.getId()==null) {
			subject.setCreateTime(new Date());
			this.subjectMapper.insert(subject);
		}else {
			subject.setUpdateTime(new Date());
			this.subjectMapper.update(subject);
		}
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		subjectMapper.delete(id);
	}

	@Override
	public Subject selectById(Integer id) {
		// TODO Auto-generated method stub
		return subjectMapper.selectById(id);
	}

}

package com.chinaopensource.interviewquestions.business.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.chinaopensource.interviewquestions.business.data.Subject;

@Mapper
@Component
public interface SubjectMapper {

	public int insert(Subject subject);
	
	public int update(Subject subject);
	
	public int delete(Integer id);
	
	public Subject selectById(Integer id);
}

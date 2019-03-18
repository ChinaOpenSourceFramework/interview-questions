package com.chinaopensource.interviewquestions.business.service;

import com.chinaopensource.interviewquestions.business.data.Classify;
import com.github.pagehelper.PageInfo;

public interface ClassifyService {

	public void save(Classify classify);
	
	public void delete(Integer id);
	
	public Classify selectById(Integer id);
	
	public PageInfo<Classify> selectByQuery(Integer pageNum, Integer pageSize);
}

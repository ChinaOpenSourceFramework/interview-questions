package com.chinaopensource.interviewquestions.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaopensource.interviewquestions.business.data.Classify;
import com.chinaopensource.interviewquestions.business.mapper.ClassifyMapper;
import com.chinaopensource.interviewquestions.business.service.ClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

	@Override
	public void save(Classify classify) {
		this.classifyMapper.insert(classify);
	}

	@Override
	public void delete(Integer id) {
		this.classifyMapper.delete(id);
	}

	@Override
	public Classify selectById(Integer id) {
		return this.classifyMapper.selectById(id);
	}

	@Override
	public PageInfo<Classify> selectByQuery(Integer pageNum, Integer pageSize) {
		//获取第1页，10条内容，默认查询总数count
	    PageHelper.startPage(pageNum, pageSize);
	    List<Classify> classifyList= this.classifyMapper.selectByQuery();
		return new PageInfo<Classify>(classifyList);
	}
	

}

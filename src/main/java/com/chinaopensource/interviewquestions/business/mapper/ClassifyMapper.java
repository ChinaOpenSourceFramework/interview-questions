package com.chinaopensource.interviewquestions.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.chinaopensource.interviewquestions.business.data.Classify;

@Mapper
@Component
public interface ClassifyMapper {

	public int insert(Classify classify);
	
	public int update(Classify classify);
	
	public int delete(Integer id);
	
	public Classify selectById(Integer id);
	
	public List<Classify> selectByQuery();
}

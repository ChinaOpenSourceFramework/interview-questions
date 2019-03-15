package com.chinaopensource.interviewquestions.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
		return BaseResponse.errorJson(ErrorMessage.ERR_SYSTERM);
	}
}

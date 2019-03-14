package com.chinaopensource.interviewquestions.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
		return BaseResponse.errorJson(ErrorMessage.ERR_SYSTERM);
	}
}

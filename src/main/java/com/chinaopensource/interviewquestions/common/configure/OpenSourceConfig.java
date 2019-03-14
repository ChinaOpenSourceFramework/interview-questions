package com.chinaopensource.interviewquestions.common.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 读取执行配置文件的类
 * create by lzl ON 2017/12/17
 */
@Configuration
@ConfigurationProperties(prefix = "opensource")
public class OpenSourceConfig {

}
package com.chinaopensource.interviewquestions.business.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	public static String PATH = "d:\\";
	public static String IMG_PATH = "file" + File.separator + "download" + File.separator + "img" + File.separator;

	// 单文件上传
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file) {

		try {
			if (file.isEmpty()) {
				return "{\"success\":\"false\"}";
			}
			// 获得文件后缀名
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String path = IMG_PATH + UUID.randomUUID().toString() + suffix;
			// 设置文件存储路径
			File dest = new File(PATH + path);
			// 检测是否存在目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();// 新建文件夹
			}
			file.transferTo(dest);// 文件写入

			String urlPath = path.replace("\\", "/");
			return "{\"success\":\"true\",\"file_path\":\"/" + urlPath + "\"}";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"success\":\"false\"}";
	}

	/**
	 * 处理图片下载请求
	 * 
	 * @param fileName
	 * @param response
	 */
	@RequestMapping("/download/img/{fileName}")
	public void downloadPicture(@PathVariable("fileName") String fileName, HttpServletResponse response) {
		// 设置下载的响应头信息
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		File imgFile = new File(PATH + IMG_PATH + fileName);
		try (InputStream is = new FileInputStream(imgFile); OutputStream os = response.getOutputStream();) {
			byte[] buffer = new byte[1024]; // 图片文件流缓存池
			while (is.read(buffer) != -1) {
				os.write(buffer);
			}
			os.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
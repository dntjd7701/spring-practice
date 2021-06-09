package com.douzone.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FiileUploadConroller {
	// Handler 제작
	// ViewResolver 없으니까. 절대 경로 적을것. 
	
	@RequestMapping({"","/form"})
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	
	/**
	 * 
	 * @param file
	 * @return
	 * 
	 *  파일의, 이름, 날짜, 사이즈, 내용 ..
	 *  모든 정보가 들어가있다. (file 에)
	 *  
	 *  중요한 것은, 후처리 과정이다. 
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file1") MultipartFile file) {
	return "/WEB-INF/views/result.jsp";
	}
	/**
	 * 
	 *  한번에 여러 파일을 처리하고 싶을 경우 
	 * @param file
	 * @return
	 * 
	 * 단, 조건으로 
	 * 그 name 이 같아야 한다. 
	 * 
	 * 
	 *	@RequestMapping(value="/upload", method=RequestMethod.POST)
	 *	public String upload(@RequestParam("file") MultipartFile[] files) {
	 *		return "/WEB-INF/views/result.jsp";
	 *	}
	 */
	
}
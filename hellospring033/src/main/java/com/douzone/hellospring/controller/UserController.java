package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @RequestMapping
 * 
 * 클래스 + Handler(메소드)
 * 
 * 제일 편하다고 하는 방법, 명시적임 
 * 
 * 
 * @author kang-woosung
 *
 */


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(){ 
		
		return "/WEB-INF/views/join.jsp";
		
	}

	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo){
		System.out.println(vo);
		// servlet context는 없어야해. 
		// 즉, hellospring03은 없어야하고, controller에서 내가 맵핑한것만. 
		return "redirect:/";

	}
}

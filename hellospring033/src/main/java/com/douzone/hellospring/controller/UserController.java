package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름의 parameter가 
		 * 없는 경우, 
		 * 400 Bad Request 에러가 발생한다. 
		 * 
		 * 그러므로 name의 default 설정을 해주는 것이 하나의 방법이다. 
		 */
		return "UserController:update : " + name;
	}
	
	

	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value = "n", required = false) String name) {
		/**
		 * 
		 * required = false 
		 * 를 함으로써 에러로 넘어가는 것을 막고 
		 * 값이 없을 경우 null을 넣는다. 
		 * 반대로, true가 기본적으로 설정되어있고, 이 설정을 바꾸지 않는다면
		 * 값이 없으면 에러로 넘어간다. 
		 * 
		 */
		return "UserController:update2 : " + name;
	}
	
	@ResponseBody
	@RequestMapping("/update3")
	public String update3(
			@RequestParam(value = "n", required = true, defaultValue="") String name, 
			@RequestParam(value = "a", required = true, defaultValue="0") int age) {
		/**
		 * defaultValue 를 ""으로 설정. 
		 * 
		 */
		return "UserController:update3 : " + name + ":" + age;
	}
}

package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	// request.getParameter처럼 요청에서 그 이름의 데이터를 받아올 수 있음. 
	// 기술침투를 방지하기 위해 doGet에서 대신 해줌 
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	// 데이터 쏴주기, (받아서 ,jsp로)
	// 하지만, 이 방식 보다는  아래의 방식을 선호 
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	// 모델을 만들어서 달라고 말하는 것.
	// name은 request로부터 끄집어 내서 넣어주고
	// model은 Handler가 만들어서 넣어주는 것. 대신 new 해서 
	// 즉, 내가 직접 new할 필요가 없음. 
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		// jsp로 데이터 쓸 수 있게. 
		model.addAttribute("name",name);
		return "/WEB-INF/views/hello4.jsp";
	}
	
}

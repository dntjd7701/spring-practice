package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 
 * 
 * RequestMapping
 * 클래스(타입) 단독 매핑
 * 
 * 
 * 
 * @author kang-woosung
 *
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	/**
	 * annotation을 붙이긴하는데
	 * 여기서 바로 주지 않고 
	 * 위에 적어줌. 
	 * 
	 * 메소드 이름을(메소드 이름으로 매핑) 통해 들어갈 수 있음. 
	 * 근데,,, 별로야 
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController:delete";
	}
}

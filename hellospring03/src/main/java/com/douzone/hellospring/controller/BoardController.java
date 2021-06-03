package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 메소드 단독 매핑
 * 
 * @author kang-woosung
 *
 */

// 꼬옥 붙여주자 .
@Controller
public class BoardController {

	/**
	 * doGet이 처리, 요청을 보내는 것임
	 *	이건 메시지이고, 브라우저로 보내는 거라고
	 *	to MessageConverter
	 */
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return	"BoardController:write";
	}
	/**
	 * 
	 * @param no
	 * 파라미터를 변수를 통해 넘겨
	 * view?no=19 << 요런식으로 안해도 됌.
	 * @return
	 * 
	 * url이 훨씬 깔끔해져 
	 * 
	 */
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable("no") Long boardNo) {
		return	"BoardController:view(" + boardNo + ")";
	}
	
	
}

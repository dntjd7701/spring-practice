package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	// url 들어오면 메소드 안의 코드가 실행된다.
	
	// 스캐닝 시에(Handler Mapping 하려고) DI를 주입해줘 !! 라고 알려주는 annotation
	// 없으면 null주고, 있으면 리턴해주고 
	// new 안해도 에러가 안난다는건, 주입이 잘되었다는 의미. 
	// annotation-config 해놨기 때문에 직접 안해도돼. 
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		
		/*
		 * 되기는 하지만, 객체를 직접 관리하지 않고
		 * 맡기도록. 
		 */
//		List<EmaillistVo> list = new EmaillistRepository().findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}

}

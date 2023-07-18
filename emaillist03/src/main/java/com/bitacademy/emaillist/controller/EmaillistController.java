package com.bitacademy.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.emaillist.repository.EmaillistRepository;
import com.bitacademy.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired				//와이어링을 해줘야한다. 안하면 NullpointException
	private EmaillistRepository ER;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<EmaillistVo> list = ER.findAll();  
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		
		return "/WEB-INF/views/add.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		ER.insert(vo);
		
		return "redirect:/";
	}
}

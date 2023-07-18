package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.guestbook.repository.GuestBookRepository;
import com.bitacademy.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookRepository GR;
	
	@RequestMapping({"/","main"})
	public String index(Model model) {
		List<GuestBookVo> list = GR.findAll();
		
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(GuestBookVo vo) {
		GR.insert(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no, Model model) {
		
		model.addAttribute("no",no);
		return "/WEB-INF/views/delete.jsp";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(Long no, String password) {
		GR.delete(no, password);
		
		return "redirect:/";
	}
	
}

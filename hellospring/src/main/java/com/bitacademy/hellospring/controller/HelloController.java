package com.bitacademy.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello1")
	public String hello1() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println("name:"+ name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name",name);
		
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello World</h1>";
	}
	
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello1";
	}
	
	@RequestMapping("/hello7")		//안좋은 코드 이럴거면 스프링안 
	public String hello7(HttpServletRequest request,
			HttpServletRequest response,
			Writer out)throws IOException {
		
		String name = request.getParameter("name");
		return "redirect:/hello1";
	}
	
}

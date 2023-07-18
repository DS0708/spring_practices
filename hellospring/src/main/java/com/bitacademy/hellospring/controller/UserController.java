package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 클래스 + 매서드(Handler) 매핑 
 * 이것을 사용하길 추천 한다.
 */

@Controller
@RequestMapping("/user")
public class UserController {
	

	@RequestMapping(value="/join",method=RequestMethod.GET)	//get방식으로 들어올때만 실행
	public String join() {
		
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)	//get방식으로 들어올때만 실행
	public String join(UserVo userVo) {			
		//POST방식일때 파라미터로 넘어오는 값들이 이름이 동일한 변수에 넣어져서 들어옴 
		//그래서 Vo의 변수 이름과 JSP의 name을 같게 해주는 것이 중요함.
		System.out.println(userVo);
		
		return "redirect:/";
	}
	
//	@ResponseBody
//	@RequestMapping("/list")
//	public String list() {
//		
//		return "UserController.list()";
//	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout() {
		
		return "UserController.logout()";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일, n이라는 이름의 파라미터가 없으면
		 * 400 bad request 에러가 발생한다.
		 */
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) String name) {
		/**
		 * 400error 가 뜨지 않게 하는 코드
		 */
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/update3")
	public String update3(@RequestParam(value="n", required=true, defaultValue="input") String name) {
		/**
		 * 무조건 넣게 해주고 default값을 내가 세팅 해주는 방법
		 * 강추
		 */
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) {
		// 자동 형변환 된다.
		return "UserController.list("+pageNo+")";
	}
}

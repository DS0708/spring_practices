package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @RequestMapping
 *  클래스 단독 매핑
 *  Spring MVC 4.x에서만 지원 !
 *  Spring MVC 5.x이상에서는 사용 금지! 
 */

//Spring MVC 5.x 이상 오류 때문에 막음 
//@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
		
		@ResponseBody
		@RequestMapping		//붙어 있어야 핸들러임, /guestbook/list rul로 접근 가
		public String list() {
			return "GuestbookController.list()";
		}
		
//		@ResponseBody
//		@RequestMapping		 
//		public String delete() {
//			return "GuestbookController.delete()";
//		}
}

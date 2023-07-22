package com.bitacademy.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.aoptest.service.ProductService;
import com.bitacademy.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
	}

}

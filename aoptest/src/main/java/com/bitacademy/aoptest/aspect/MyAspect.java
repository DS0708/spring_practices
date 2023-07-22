package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
	@After("exectuion(com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}

	@AfterReturning("exectuion(* *..*.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("--- After Returning Advice ---");
	}
}

package com.bitacademy.aoptest.vo;

public class ProductVo {
	private String name;

	public ProductVo(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
	
}

package com.bitacademy.container.user;

import org.springframework.stereotype.Component;

@Component
public class Friend {
	private Long no = 1L;
	private String name = "micol";
	
	
	//Auto Configuration(Component Scan) 빈 생성시에는 반드시 기본 생성자가 있어야 함.
	public Friend() {
		
	}
	
	public Friend(String name) {
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [no=" + no + ", name=" + name + "]";
	}
}

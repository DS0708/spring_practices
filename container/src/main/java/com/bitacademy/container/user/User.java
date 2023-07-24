package com.bitacademy.container.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no = 0L;
	private String name = "dooly";
	private String[] friends;
	
	public String[] getFriends() {
		return friends;
	}

	public void setFriends(String[] friends) {
		this.friends = friends;
	}

	@Autowired
	private Friend friend = null;
	
	
	public User() {
		this.name = name;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}

	public User(Long no, String name, Friend friend) {
		super();
		this.no = no;
		this.name = name;
		this.friend = friend;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friends=" + Arrays.toString(friends) + ", friend=" + friend
				+ "]";
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
	
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
}

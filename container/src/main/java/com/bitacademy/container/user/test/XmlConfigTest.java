package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		//1. XML Auto Configuration(Annotation Configuration)
		//testXMLAutoConfiguration();
		
		//2. XML Explicit Configuration(Bean Configuration)
		testXMLExplicitConfiguration();
	}

	private static void testXMLExplicitConfiguration() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		//id로 가져오기 
		//명시적 빈설정인 경우에는 id를 자동으로 부여하지는 않는다.
//		user = (User) ac.getBean("user");
//		System.out.println(user);
		
		
		//id로 가져오기 
		//명시적 빈설정인 경우에는 id를 자동으로 부여하지는 않는다.
		user = (User) ac.getBean("user2");
		System.out.println(user);
		
		//name으로 가져오기 
		user = (User) ac.getBean("usr2");
		System.out.println(user);
		
		//type으로 Bean 가져오기
		// 같은 타입의 Bean이 2개 이상 있으면 Type으로만 가져오기는 실패 
		// 1. id + Type
		// 2. name + Type
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		user = ac.getBean("usr2", User.class);
		System.out.println(user);
		
		// 파라미터 1개인 생성자로 빈 생성하기 
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 빈 생성하기 
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		//DI : setter
		user = ac.getBean("user7", User.class);
		System.out.println(user);
		
		//DI : Constructor
		user = ac.getBean("user8", User.class);
		System.out.println(user);
		
		//setter(list 세팅)를 사용한 빈 가져오기
		user = ac.getBean("user9", User.class);
		System.out.println(user);
	}

	private static void testXMLAutoConfiguration() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext01.xml");
		
		User user = null;
		
//		user = ac.getBean(User.class);
//		System.out.println(user);
		
		//Annotation Scan 설정에서는 bean id 가 자동으로 부어된다.
		user = (User)ac.getBean("user");
		System.out.println(user);
		
	}

}

package com.hcl.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Hello.xml");
		Hello h=(Hello)ctx.getBean("bean1");
		System.out.println(h.SayHello("Raghu"));
	}

}

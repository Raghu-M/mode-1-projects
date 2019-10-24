package com.hcl.employ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employ.xml");
		DataInsertDao c=(DataInsertDao)ctx.getBean("bean1");
		c.inserEmploy();
		System.out.println("\nEmploy Inserted");
	}

}

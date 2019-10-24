package com.hcl.inventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("order.xml");
		OrderLogic ol =(OrderLogic)ctx.getBean("oLogic");
		ol.display();
	}

}

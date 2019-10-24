package com.hcl.calc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Calc.xml");
		Calc c=(Calc)ctx.getBean("bean1");
		System.out.println("sum  : "+c.add());
		System.out.println("sub  : "+c.sub());
		System.out.println("mul  : "+c.mul());
	}
}

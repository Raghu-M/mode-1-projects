package com.hcl.employ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProgEmpSearch {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employSearch.xml");
		EmploySearch c=(EmploySearch)ctx.getBean("bean1");
		c.employSearch();
	}

}

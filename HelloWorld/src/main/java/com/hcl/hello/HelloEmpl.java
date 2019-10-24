package com.hcl.hello;

public class HelloEmpl implements Hello{
	
	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public String SayHello(String name) {
		// TODO Auto-generated method stub
		return greeting+name;
	}
}

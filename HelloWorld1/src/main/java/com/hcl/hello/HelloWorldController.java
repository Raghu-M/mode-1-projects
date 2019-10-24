package com.hcl.hello;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public  ModelAndView helloWorld(){
		return new ModelAndView("result","message","Welcome to Spring");
	}
	
	@RequestMapping("/bhargav")
	public  ModelAndView hello(){
		return new ModelAndView("result","message","hello bhargav");
	}
	
	@RequestMapping("/calc")
	public  ModelAndView add(HttpServletRequest req, HttpServletResponse res){
		int a = Integer.parseInt(req.getParameter("first"));
		int b = Integer.parseInt(req.getParameter("second"));
		
		return new ModelAndView("result","message","The Sum Of 2 number is  :"+(a+b));
	}
	
	@RequestMapping("/fullName")
	public  ModelAndView fullName(HttpServletRequest req, HttpServletResponse res){
		String a = req.getParameter("first");
		String b = req.getParameter("second");
		String c = a+" "+b;
		
		return new ModelAndView("result","message","FullName  :"+c);
	}
	
	@RequestMapping("/names")
	public  ModelAndView names(HttpServletRequest req, HttpServletResponse res){
		List<String> lst = new ArrayList<String>();
		lst.add("Raghu");
		lst.add("vinod");
		lst.add("prem");
		lst.add("Sai Kumar");
		lst.add("Yash");
		lst.add("Adithya");
		return new ModelAndView("show","message",lst);
	}
	
	@RequestMapping("/login")
	public  ModelAndView login(HttpServletRequest req, HttpServletResponse res){
		if(req.getParameter("user").equals("raghu") && req.getParameter("password").equals("jerry")){
			return new ModelAndView("LoggedIn","message","SuccessFully LoggedIn");
		} else {
			return new ModelAndView("Error","message","Error404");
		}
	}

}

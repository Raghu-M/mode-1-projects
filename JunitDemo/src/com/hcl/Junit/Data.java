package com.hcl.Junit;

public class Data {
	public String hello(){
		return "Welcome to Junit";
	}
	public int sum(int a, int b){
		return a+b;
	}
	public int max(int a,int b, int c){
		int max = a;
		if(max<b)max=b;
		if(max<c)max =c;
		return max;
	}
	public int minArray(int []x){
		int min = x[1];
		for(int i :x){
			if(min>i)min=i;
		}
		return min;
	}
	public boolean even(int n){
		if((n%2)==0)return true;
		else return false;
	}
	public int div(int a, int b){
		int c=0;
		try {
			c = a/b;
		} catch (ArithmeticException e) {
			System.out.print("zero");
		}
		return c ;
	}
}

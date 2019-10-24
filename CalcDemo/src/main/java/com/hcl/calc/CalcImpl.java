package com.hcl.calc;


public class CalcImpl implements Calc{
	private int firstNo;
	private int secondNo;
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getSecondNo() {
		return secondNo;
	}
	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}
	public int add() {
		// TODO Auto-generated method stub
		return firstNo+secondNo;
	}
	public int sub() {
		// TODO Auto-generated method stub
		return firstNo-secondNo;
	}
	public int mul() {
		// TODO Auto-generated method stub
		return firstNo*secondNo;
	}
	
	
}

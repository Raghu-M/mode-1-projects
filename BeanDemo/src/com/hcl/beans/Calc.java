package com.hcl.beans;

public class Calc {
	private int fnum;
	private int lnum;
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getLnum() {
		return lnum;
	}
	public void setLnum(int lnum) {
		this.lnum = lnum;
	}
	public int sum(){
		return getFnum()+getLnum();
	}
}

package com.hcl.bank;

public class Trans {
	private int AccountNo;
	private String TransType;
	private int TransAmount;
	private int AccBalance; 
	private  String TransDate;
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	public int getTransAmount() {
		return TransAmount;
	}
	public void setTransAmount(int transAmount) {
		TransAmount = transAmount;
	}
	public int getAccBalance() {
		return AccBalance;
	}
	public void setAccBalance(int accBalance) {
		AccBalance = accBalance;
	}
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	@Override
	public String toString() {
		return "Trans [AccountNo=" + AccountNo + ", TransType=" + TransType + ", TransAmount=" + TransAmount
				+ ", AccBalance=" + AccBalance + ", TransDate=" + TransDate + "]";
	} 
	
}

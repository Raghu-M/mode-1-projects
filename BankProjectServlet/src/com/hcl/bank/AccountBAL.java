package com.hcl.bank;

import java.util.List;

public class AccountBAL {
	
	public static String createAccountBal(Accounts objAccounts){
		return new AccountDAO().createAccountDao(objAccounts);	
	}
	
	public static int generateAccountNoBal(){
		return new AccountDAO().generateAccountNoDao(); 
	}
	public static Accounts searchAccountBal(int accno){
		return new AccountDAO().searchAccountDao(accno);
	}
	public static String updateAccountBal(Accounts objAcc){
		return new AccountDAO().updateAccountDao(objAcc);
	}
	public static String closeAccountBal(int accno){
		return new AccountDAO().closeAccountDao(accno);
	}
	public static String depositAccountBal(int accno, int depAmount){
		return new AccountDAO().depositAccountDao(accno,depAmount);
	}
	public static String withdrawAccountBal(int accno, int depAmount){
		return new AccountDAO().withdrawAccountDao(accno,depAmount);
	}
	public static List<Trans> miniSmtBal(int accno){
		return new AccountDAO().miniSmtDao(accno);
	}

}

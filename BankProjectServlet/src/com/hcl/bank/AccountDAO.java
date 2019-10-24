package com.hcl.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountDAO {
	PreparedStatement pst;
	Connection con;
//------------------------------------------------------------------------------------	
	public String createAccountDao(Accounts objAccounts){
		con = DaoConnection.getconnection();
		String cmd = "Insert into Accounts(AccountNo,"
          + "FirstName,LastName, City,State,Amount,CheqFacil,AccountType) "
          + "values(?,?,?,?,?,?,?,?)";
		String result = "";
		try {
			objAccounts.setAccountNo(AccountBAL.generateAccountNoBal());
			pst = con.prepareStatement(cmd);
			pst.setInt(1, objAccounts.getAccountNo());
			pst.setString(2, objAccounts.getFirstName());
			pst.setString(3, objAccounts.getLastName());
			pst.setString(4, objAccounts.getCity());
			pst.setString(5, objAccounts.getState());
			pst.setInt(6, objAccounts.getAmount());
			pst.setString(7, objAccounts.getCheqFacil());
			pst.setString(8, objAccounts.getAccountType());
			pst.executeUpdate();
			cmd = "insert into trans(AccountNo,TransAmount,TransType,Accbalance) "
					+ "values(?,?,?,?);";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, objAccounts.getAccountNo());
			pst.setInt(2, objAccounts.getAmount());
			pst.setString(3, "Ac Credit");
			pst.setInt(4, objAccounts.getAmount());
			pst.executeUpdate();
			result = "Account Created Successfully......";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
//------------------------------------------------------------------------------------
	public int generateAccountNoDao(){
		con = DaoConnection.getconnection();
		int accno = 0;
		String cmd =  "select case when max(accountno) is null "
				+ "then 1 else max(accountno)+1 end accno "
				+ "From Accounts";
		try {
			pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			rs.next();
			accno = rs.getInt("accno");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accno;
		
	}
//------------------------------------------------------------------------------------	
	public Accounts searchAccountDao(int accno){
		con = DaoConnection.getconnection();
		Accounts objAccount = null;
		String cmd = "Select * from Accounts where accountno = ?";
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, accno);
		    ResultSet rs = pst.executeQuery();
		    if(rs.next()){
		        objAccount  = new Accounts();
		    	objAccount.setAccountNo(rs.getInt("AccountNo"));
		    	objAccount.setFirstName(rs.getString("FirstName"));
		    	objAccount.setLastName(rs.getString("LastName"));
		    	objAccount.setCity(rs.getString("City"));
		    	objAccount.setState(rs.getString("State"));
		    	objAccount.setAmount(rs.getInt("Amount"));
		    	objAccount.setCheqFacil(rs.getString("CheqFacil"));
		    	objAccount.setAccountType(rs.getString("AccountType"));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  objAccount;
	}
//------------------------------------------------------------------------------------	
	public String updateAccountDao(Accounts objAcc){
	    con = DaoConnection.getconnection();
		Accounts objAccount = new AccountDAO().searchAccountDao(objAcc.getAccountNo());
		if(objAccount != null){
			String cmd = "update Accounts set City = ?,State = ? where AccountNo = ?";
			try {
				PreparedStatement pst = con.prepareStatement(cmd);
				pst.setString(1, objAcc.getCity());
				pst.setString(2, objAcc.getState());
				pst.setInt(3, objAcc.getAccountNo());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Account Updated Successfull......";
		} else return "Account not found.......";
		
		
	}
//------------------------------------------------------------------------------------	
	public String closeAccountDao(int accno){
		con = DaoConnection.getconnection();
		Accounts objAccount = new AccountDAO().searchAccountDao(accno);
		if(objAccount != null){
			String cmd = "update Accounts set status = 'inactive' where AccountNo = ?";
			try {
				PreparedStatement pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Account closed Successfully......";
		} else return "Account not found.......";
	}
//------------------------------------------------------------------------------------	
	public String depositAccountDao(int accno, int depAmount){
		con = DaoConnection.getconnection();
		Accounts objAccount = new AccountDAO().searchAccountDao(accno);
		if(objAccount != null){
			String cmd = "Select status from Accounts Where AccountNo = ?";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				ResultSet rs = pst.executeQuery();
				rs.next();
				String status = rs.getString("status");
				if(status.equals("inactive")) return "account is inactive";
				cmd = "update Accounts set amount = amount+? "
						+ "where AccountNo = ?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, depAmount);
				pst.setInt(2, accno);
				pst.executeUpdate();
				cmd = "Select amount from Accounts Where AccountNo = ?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				rs = pst.executeQuery();
				rs.next();
				cmd = "insert into trans(AccountNo,TransAmount,TransType,Accbalance) "
						+ "values(?,?,?,?);";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				pst.setInt(2, depAmount);
				pst.setString(3, "Credit");
				pst.setInt(4, rs.getInt("Amount"));
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Amount Credited......";
		} else return "Account Number not Found.....";
	}
//------------------------------------------------------------------------------------	
	public String withdrawAccountDao(int accno, int depAmount){
		con = DaoConnection.getconnection();
		Accounts objAccount = new AccountDAO().searchAccountDao(accno);
		if(objAccount != null){
			String cmd = "Select status from Accounts Where AccountNo = ?";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				ResultSet rs = pst.executeQuery();
				rs.next();
				String status = rs.getString("status");
				if(status.equals("inactive")) return "account is inactive";
				
				cmd = "select amount from accounts where AccountNo=?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				rs = pst.executeQuery();
				rs.next();
				int amount = rs.getInt("amount");
				if(amount < depAmount) 
					return "the Availabe Amount in your Account is  - Rs "+amount+"\n\nPlease Enter Lesser Amount";
				
				cmd = "update Accounts set amount = amount-? "
						+ "where AccountNo = ?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, depAmount);
				pst.setInt(2, accno);
				pst.executeUpdate();
				cmd = "Select amount from Accounts Where AccountNo = ?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				rs = pst.executeQuery();
				rs.next();
				cmd = "insert into trans(AccountNo,TransAmount,TransType,Accbalance) "
						+ "values(?,?,?,?);";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				pst.setInt(2, depAmount);
				pst.setString(3, "Debit");
				pst.setInt(4, rs.getInt("amount"));
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Amount Debited......";
		} else return "Account Number not Found.....";
	}
//------------------------------------------------------------------------------------
	public List<Trans> miniSmtDao(int accno){
		con = DaoConnection.getconnection();
		Accounts objAccount = new AccountDAO().searchAccountDao(accno);
		List<Trans> trans = null;
		Trans obj;
		String cmd = "select * from Trans where accountno = ?";
		if(objAccount != null){
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(cmd);
				pst.setInt(1, accno);
				ResultSet rs = pst.executeQuery();
				trans = new ArrayList<Trans>();
				while(rs.next()){
					obj = new Trans();
					obj.setAccountNo(rs.getInt("AccountNo"));
					obj.setTransType(rs.getString("TransType"));
					obj.setTransAmount(rs.getInt("TransAmount"));
					obj.setAccBalance(rs.getInt("AccBalance"));
					obj.setTransDate(rs.getString("transDate"));
					trans.add(obj);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trans;
	}
//----------------------------------------------------------------------------------	
}

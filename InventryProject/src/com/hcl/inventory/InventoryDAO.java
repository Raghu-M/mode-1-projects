package com.hcl.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDAO {
	Connection con;
	PreparedStatement pst;
	public String generateStockIdDao(){
		con = DaoConnection.getconnection();
		String stockid = null;
		String cmd = "select stockid from stock";
		int num;
		try {
			pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				stockid = rs.getString("stockid");
			}
			num = Integer.parseInt(stockid.substring(1));
			num++;
			if(num < 10){
				stockid = "S00"+num;
			} else if(num < 100){
				stockid = "S0"+num;
			} else {
				stockid = "S"+num;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockid;
	}
	
	public String addInventoryDao(Inventory obj){
		con = DaoConnection.getconnection();
		String cmd = "insert into stock values(?,?,?,?)";
		try {
			pst = con.prepareStatement(cmd);
			pst.setString(1, obj.getStockId());
			pst.setString(2, obj.getItemName());
			pst.setInt(3, obj.getPrice());
			pst.setInt(4, obj.getQuantityAvail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "item added";
	}
}

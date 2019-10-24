package com.hcl.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDAO {
	
//----------------------------------------------------------------------------------------------
	public String generateStockIdDao(){
		Connection con = DaoConnection.getconnection();
		String stockid = "A000";
		String cmd = "select max(stockid)  sid from stock";
		int num;
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			rs.next();
				stockid = rs.getString("sid");
			num = Integer.parseInt(stockid.substring(1))+1;
			stockid = "S"+String.format("%03d", num);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockid;
	}
//------------------------------------------------------------------------------------------------	
	public String addInventoryDao(Inventory obj){
		 Connection con = DaoConnection.getconnection();
		String cmd = "insert into stock values(?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, new InventoryDAO().generateStockIdDao());
			pst.setString(2, obj.getItemName());
			pst.setInt(3, obj.getPrice());
			pst.setInt(4, obj.getQuantityAvail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "item added";
	}
//-------------------------------------------------------------------------------------------------
	public Inventory searchInventoryDao(String stockid) {
		Connection con = DaoConnection.getconnection();
		Inventory obj = null;
		String cmd = "select * from stock where StockId = ?";
		try {
			PreparedStatement pst  = con.prepareStatement(cmd);
			pst.setString(1, stockid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				obj = new Inventory();
				obj.setStockId(rs.getString("StockId"));
				obj.setItemName(rs.getString("ItemName"));
				obj.setPrice(rs.getInt("Price"));
				obj.setQuantityAvail(rs.getInt("QuantityAvail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
//------------------------------------------------------------------------------------------------
	public String updateInventoryDao(Inventory obj) {
		Connection con = DaoConnection.getconnection();
		Inventory obj1 = new InventoryDAO().searchInventoryDao(obj.getStockId());
		String cmd = "update stock set price = ?, quantityavail = quantityavail + ? where StockId = ?";
		if(obj1 != null) {
			try {
				PreparedStatement pst = con.prepareStatement(cmd);
				pst.setInt(1, obj.getPrice());
				pst.setInt(2, obj.getQuantityAvail());
				pst.setString(3, obj.getStockId());
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Item Updated Successfully.....";
		} else return "Item not Found...........";
	}
//-----------------------------------------------------------------------------------------------
	public String orderInventoryDao(String stockid,int quantityReq) {
		Connection con = DaoConnection.getconnection();
		String cmd = "select quantityAvail, price from stock where Stockid = ?";
		String res = "Item not Found";
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, stockid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(quantityReq <= rs.getInt("quantityAvail")) {
					int price = rs.getInt("price");
					cmd = "update stock set quantityavail = quantityavail-? where stockid = ? ";
					pst = con.prepareStatement(cmd);
					pst.setInt(1, quantityReq);
					pst.setString(2, stockid);
					pst.executeUpdate();
					cmd = "select max(orderid) ord from orders";
					pst = con.prepareStatement(cmd);
					rs = pst.executeQuery();
					int orderid = 1;
					if(rs.next()){
						orderid = rs.getInt("ord")+1;
					}
					cmd = "insert into orders(orderid, stockid, qtyord, billamt) values(?,?,?,?) ";
					pst = con.prepareStatement(cmd);
					pst.setInt(1, orderid);
					pst.setString(2, stockid);
					pst.setInt(3, quantityReq);
					pst.setInt(4, quantityReq*price);
					pst.executeUpdate();
					cmd = "update Amount set gamt = gamt+? ";
					pst = con.prepareStatement(cmd);
					pst.setInt(1, quantityReq*price);
					pst.executeUpdate();
					res = "order Placed";
				}else res = "Quantity is Not available";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}








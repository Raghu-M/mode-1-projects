package com.hcl.servlet;

public class InventoryBAL {
	
	public static String addInventoryBal(Inventory obj){
		return new InventoryDAO().addInventoryDao(obj);
	}
	
	public static Inventory searchInventoryBal(String stockid) {
		return new InventoryDAO().searchInventoryDao(stockid);
	}
	
	public static String updateInventoryBal(Inventory obj) {
		return new InventoryDAO().updateInventoryDao(obj);
	}
	
	public static String orderInventoryBal(String stockid,int quantityReq) {
		return new InventoryDAO().orderInventoryDao(stockid,quantityReq);
	}
}

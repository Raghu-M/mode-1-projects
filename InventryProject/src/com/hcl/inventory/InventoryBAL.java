package com.hcl.inventory;

public class InventoryBAL {
	public static String addInventoryBal(Inventory obj){
		return new InventoryDAO().addInventoryDao(obj);
	}

}

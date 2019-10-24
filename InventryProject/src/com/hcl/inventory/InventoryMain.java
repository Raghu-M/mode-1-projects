package com.hcl.inventory;

import java.util.Scanner;

public class InventoryMain {
	
	public void addInventory(){
		Scanner sc = new Scanner(System.in);
		Inventory obj = new Inventory();
		obj.setStockId(new InventoryDAO().generateStockIdDao());
		System.out.println("enter ItemName, Price, QuantityAvail");
		obj.setItemName(sc.next());
		obj.setPrice(sc.nextInt());
		obj.setQuantityAvail(sc.nextInt());
		System.out.println(InventoryBAL.addInventoryBal(obj));
	}
	
	public static void main(String[] args) {
		System.out.println("enter a choice : "
			      + "\n----------------------------");
	System.out.println("1 : Add Inventory");
	System.out.println("2 : Search Account");
	System.out.println("3 : Update Account");
	System.out.println("4 : Close Account");
	System.out.println("5 : Deposit Amount");
	System.out.println("6 : WithDraw Amount");
	System.out.println("7 : Mini Statement");
	System.out.println("---------------------------");
		new InventoryMain().addInventory();
	}

}

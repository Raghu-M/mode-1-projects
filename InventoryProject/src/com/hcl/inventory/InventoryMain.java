package com.hcl.inventory;

import java.util.Scanner;

public class InventoryMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public void addInventory(){
		Inventory obj = new Inventory();
		System.out.println("enter ItemName, Price, QuantityAvail");
		obj.setItemName(sc.next());
		obj.setPrice(sc.nextInt());
		obj.setQuantityAvail(sc.nextInt());
		System.out.println(InventoryBAL.addInventoryBal(obj));
	}
	
	public void searchInventory() {
		System.out.println("ENTER STOCK ID ");
		String stockid = sc.next();
		System.out.println(InventoryBAL.searchInventoryBal(stockid));
	}
	
	public void updateInventory() {
		Inventory obj = new Inventory();
		System.out.println("Enter StockId, Price, Quantity");
		obj.setStockId(sc.next());
		obj.setPrice(sc.nextInt());
		obj.setQuantityAvail(sc.nextInt());
		System.out.println(InventoryBAL.updateInventoryBal(obj));
	}
	
	public void orderInventory() {
		System.out.println("Enter StockId, Quantity");
		String stockid = sc.next();
		int quantityReq = sc.nextInt();
		System.out.println(InventoryBAL.orderInventoryBal(stockid, quantityReq));
	}
	
	public static void main(String[] args) {
		System.out.println("ENTER : ");
		System.out.println("-------------------------------------------------------");
		System.out.println("1 : ADD INVENTORY");
		System.out.println("2 : SEARCH INVENTORY");
		System.out.println("3 : UPDATE INVENTORY");
		System.out.println("4 : ORDER INVENTORY");
		System.out.println("-------------------------------------------------------");
		while(true) {
			switch(sc.nextInt()) {
			case 1: 	
				new InventoryMain().addInventory();
				break;
			case 2: 	
				new InventoryMain().searchInventory();
				break;
			case 3: 	
				new InventoryMain().updateInventory();
				break;
			case 4: 	
				new InventoryMain().orderInventory();
				break;
			default :
				System.out.println("INVALID CHOICE........");
			}
		}
	}

}

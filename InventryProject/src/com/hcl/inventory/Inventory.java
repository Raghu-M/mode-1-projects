package com.hcl.inventory;

public class Inventory {
	private String stockId;
	private String itemName;
	private int price;
	private int quantityAvail;
	
	
	public String getStockId() {
		return stockId;
	}


	public void setStockId(String stockId) {
		this.stockId = stockId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantityAvail() {
		return quantityAvail;
	}


	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}


	@Override
	public String toString() {
		return "Inventory [stockid=" + stockId + ", itemname=" + itemName + ", price=" + price + ", quantityAvail="
				+ quantityAvail + "]";
	}
	
	

}

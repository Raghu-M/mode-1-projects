package com.hcl.inventory;

public class Product {
	private String product;
	private int quantityAvail;
	private int price;
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantityAvail() {
		return quantityAvail;
	}
	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void product(){
		System.out.println("product "+product+"quantityAvail "+quantityAvail+"Price "+price);
	}
	
}

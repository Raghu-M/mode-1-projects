package com.hcl.inventory;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void testaddInventory() {
		Inventory obj = new Inventory();
		obj.setItemName("papaya");
		obj.setPrice(50);
		obj.setQuantityAvail(30);
		assertEquals("item added",InventoryBAL.addInventoryBal(obj));
		
	}
	@Test
	public void testSearchInventory(){
		assertNotNull(InventoryBAL.searchInventoryBal("s001"));
		assertNull(InventoryBAL.searchInventoryBal("t001"));
		assertNull(new InventoryBAL().searchInventoryBal("s999"));
	}
	
	@Test
	public void testUpdateInventory() {
		Inventory obj = new Inventory();
		obj.setStockId("s001");
		obj.setPrice(50);
		obj.setQuantityAvail(30);
		assertEquals("Item Updated Successfully.....",InventoryBAL.updateInventoryBal(obj));
		obj.setStockId("u001");
		assertEquals("Item not Found...........",InventoryBAL.updateInventoryBal(obj));

	}
	
	@Test
	public void testOrderInventory(){
		assertEquals("order Placed",InventoryBAL.orderInventoryBal("s001", 1));
		assertEquals("Quantity is Not available",InventoryBAL.orderInventoryBal("s001", 1000));
		assertEquals("Item not Found",InventoryBAL.orderInventoryBal("u001", 1000));
		
	}
	
	@Test
	public void testGetterSetterInventory(){
		Inventory obj = new Inventory();
		obj.setItemName("papaya");
		obj.setPrice(50);
		obj.setQuantityAvail(30);
		obj.setStockId("s001");
		assertEquals("papaya",obj.getItemName());
		assertEquals(50,obj.getPrice());
		assertEquals(30,obj.getQuantityAvail());
		assertEquals("s001",obj.getStockId());
	}
}

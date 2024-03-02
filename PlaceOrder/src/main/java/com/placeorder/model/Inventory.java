package com.placeorder.model;

public class Inventory {
	
	
	private int inventoryId;
	
	
	private String inventoryName;
	

	private int available;
	
	
	private int consumed;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getConsumed() {
		return consumed;
	}

	public void setConsumed(int consumed) {
		this.consumed = consumed;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", available=" + available
				+ ", consumed=" + consumed + "]";
	}
	
	

}

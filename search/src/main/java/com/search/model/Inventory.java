package com.search.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {
	
	 @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)    
	 @Column(name="inventory_id")
	private int inventoryId;
	
	 @Column(name="inventory_name")  
	private String inventoryName;
	
	 @Column(name="available")
	private int available;
	
	 @Column(name="consumed")
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
	
	

}

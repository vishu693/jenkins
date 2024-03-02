package com.oms.model;

public class PlaceOrder {
	
	
	private int orderId;
	private int accountId;
	private String userName;
	private int inventoryId;
	private String inventoryName;
		
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	@Override
	public String toString() {
		return "PlaceOrder [orderId=" + orderId + ", accountId=" + accountId + ", userName=" + userName
				+ ", inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + "]";
	}
	
	
}

package com.search.advice;

public class InventoryNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryNotFound(String product)
	{
		super("Inventory not  found "+product);
	}

}

package com.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.model.Inventory;

@Repository
public interface InvertoryRepo extends JpaRepository<Inventory, Integer>{
	
	Inventory findByinventoryName(String inventoryName);
	
	
}

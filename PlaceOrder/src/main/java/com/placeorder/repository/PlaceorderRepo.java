package com.placeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placeorder.model.PlaceOrder;

@Repository
public interface PlaceorderRepo extends JpaRepository<PlaceOrder, Integer>{
	
	

}

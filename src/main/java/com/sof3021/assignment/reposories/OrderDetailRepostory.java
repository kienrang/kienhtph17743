package com.sof3021.assignment.reposories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;

@Repository
public interface OrderDetailRepostory extends JpaRepository<OrderDetails, Integer>{
	
	@Query("SELECT od FROM OrderDetails od WHERE od.orders = :id")
	public List<OrderDetails> findByOrder_id(@Param("id") Orders id);
}

package com.sof3021.assignment.reposories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	@Query("SELECT o FROM Orders o WHERE o.id = :id")
	public Orders findByIdOder(@Param("id") Integer id);
	
	@Query("Select o From Orders o WHERE o.acc.id = :id")
	public List<Orders> findByIdAcc(@Param("id")Integer acc);
	
}

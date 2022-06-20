package com.sof3021.assignment.reposories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Cart;
import com.sof3021.assignment.entities.Orders;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("SELECT c FROM Cart c WHERE c.user = :keyword")
	public List<Cart> findByCartAcc(@Param("keyword")Account id);
	
//	@Query("Delete c FROM Cart c WHERE c.user = :keyword")
//	public void DeleteByUser(@Param("keyword")Account id);
	
}

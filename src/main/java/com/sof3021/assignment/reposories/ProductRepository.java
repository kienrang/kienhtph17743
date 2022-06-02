package com.sof3021.assignment.reposories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Categories;
import com.sof3021.assignment.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	
	@Query("SELECT p FROM Products p WHERE p.id = :id")
	public Products findByProductEqual(@Param("id")Integer id);
}

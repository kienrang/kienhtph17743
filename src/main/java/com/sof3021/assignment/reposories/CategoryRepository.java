package com.sof3021.assignment.reposories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer>{
	 	@Query("SELECT c FROM Categories c WHERE c.id = :keyword")
		public Categories findByCateEqual(@Param("keyword")Integer id);

}

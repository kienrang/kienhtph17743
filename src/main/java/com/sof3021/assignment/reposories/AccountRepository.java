package com.sof3021.assignment.reposories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("SELECT acc FROM Account acc WHERE acc.email = :email")
	public Account findByEmailUser(@Param("email")String email);
	@Query("SELECT acc FROM Account acc WHERE acc.id = :id")
	public Account findByIdUser(@Param("id")Integer id); 
}

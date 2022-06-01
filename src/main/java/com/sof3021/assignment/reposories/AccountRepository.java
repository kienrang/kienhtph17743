package com.sof3021.assignment.reposories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}

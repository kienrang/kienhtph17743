package com.sof3021.assignment.reposories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sof3021.assignment.entities.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer>{

}

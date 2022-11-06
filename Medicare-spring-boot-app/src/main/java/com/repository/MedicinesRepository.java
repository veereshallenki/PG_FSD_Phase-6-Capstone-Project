package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Medicines;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines, Integer> {

	// public boolean existsby
	public boolean existsByname(String name);
	
	@Query("select name from Medicines u where name like ?1% ")
	public List<String> getNames(String input);   
	
	@Query("select id from Medicines u where name like ?1 ")
	public Integer getIdByName(String name);  

}

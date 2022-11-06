package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.MedicareUsers;

@Repository
public interface MedicareUsersRepository extends JpaRepository<MedicareUsers, Integer> {

	//public boolean existsby 	
	public boolean existsByemail(String email); 	

	
	@Query("select count(1) from MedicareUsers u where email = ?1 and password = ?2 ") 
	public int validateSignIn(String email, String pwd);
	
	
	
	
}

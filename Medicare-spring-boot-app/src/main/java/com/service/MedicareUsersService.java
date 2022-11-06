package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.MedicareUsers;
import com.repository.MedicareUsersRepository;

@Service
public class MedicareUsersService {

	@Autowired
	MedicareUsersRepository mr;

	public String storeUser(MedicareUsers m) {

		// if the respective e-mail not present then insert else messea
		if (!mr.existsByemail(m.getEmail())) {
			mr.save(m);			
			return "User added " + m.getName();
		} else {
			return "E-mail is already present and select any other e-mail Id";
		}

		/*
		 * Optional<MedicareUsers> op = mr.findById(m.getId());
		 * 
		 * mr.save(m); return "User added " + m.getName();
		 */

		/*
		 * if (op.isPresent()) { return "User id must be Unique"; } else { mr.save(m);
		 * return "User added succesfully"; }
		 */
	}

	
	//to validate the email and pwd which is present correct or not	
	public String validateSignDetails(String email, String pwd) {
		
		if (!mr.existsByemail(email))
		{
			return "e-mail not registered and please sign up ";
		}
		
		int res = mr.validateSignIn(email, pwd);

		if (res == 1) {
			return "Sign-in success!!";
		} else {
			return "Please enter the correct user name and password";
		}
	}
	

	public List<MedicareUsers> findAllUsers() {
		return mr.findAll();
	}

	// based on Id provide the all the data out
	public MedicareUsers findUserInfoByemail(int id) {
		Optional<MedicareUsers> op = Optional.ofNullable(mr.findById(id).get());
		// MedicareUsers userlist = null;
		if (op.isPresent()) {
			MedicareUsers mm = op.get();
			return mm;
		} else {
			return null; // TO-DO have to impliment exception to avoid run time exception
		}
	}

	public String updateUser(MedicareUsers m) {
		System.out.println("User id from the input is " + m.getId());
		System.out.println("User name from the input is " + m.getName());
		Optional<MedicareUsers> op = mr.findById(m.getId());

		if (op.isPresent()) {
			MedicareUsers m1 = op.get();
			m1.setPassword(m.getPassword());
			mr.saveAndFlush(m1);
			return "Used Details updated successfully";
		} else {
			return "User not Present in the System";
		}
	}

	public String deleteUser(int id) {
		Optional<MedicareUsers> op = mr.findById(id);

		if (op.isPresent()) {
			MedicareUsers mm = op.get();
			mr.delete(mm);
			return "User Deleted";
		} else {
			return "User not present";
		}
	}

}

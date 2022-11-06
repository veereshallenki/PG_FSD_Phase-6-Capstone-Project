package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.MedicareUsers;
import com.service.MedicareUsersService;

@RestController
@RequestMapping("user")
@CrossOrigin //enable cross origin feature to call rest API
public class MedicareUsersController {

	@Autowired
	MedicareUsersService ms;

	// http://localhost:9797/user/storeUsers
	@PostMapping(value = "/storeUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeUsers(@RequestBody MedicareUsers users) {
		return ms.storeUser(users);
	}

	// http://localhost:9797/user/findAllUsers
	@GetMapping(value = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MedicareUsers> findAllUsers() {
		return ms.findAllUsers();
	}

	// http://localhost:9797/user/findById
	@GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicareUsers getUserbyId(@RequestParam("id") int id) {
		return ms.findUserInfoByemail(id);
		// return ms.findBYI
	}

	
	// sign in validation
	// http://localhost:9797/user/signin
	@GetMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateSignIn(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		return ms.validateSignDetails(email, pwd);
	}
	

	// http://localhost:9797/user/updateUser
	@PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUsers(@RequestBody MedicareUsers users) {
		return ms.updateUser(users);
	}

	// http://localhost:9797/user/deleteUser/3
	@DeleteMapping(value = "/deleteUser/{pid}")
	public String deleteUser(@PathVariable("pid") int id) {
		return ms.deleteUser(id);
	}

}

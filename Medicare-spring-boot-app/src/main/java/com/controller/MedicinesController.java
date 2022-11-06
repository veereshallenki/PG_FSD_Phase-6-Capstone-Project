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
import com.bean.Medicines;
import com.service.MedicinesService;

@RestController
@RequestMapping("medicine")
@CrossOrigin // enable cross origin feature to call rest API
public class MedicinesController {

	@Autowired
	MedicinesService ms;

	// http://localhost:9797/medicine/configureMedicine
	@PostMapping(value = "/configureMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String configureMedicine(@RequestBody Medicines m) {
		return ms.configureMedicine(m);
	}

	// http://localhost:9797/medicine/updateMedicine
	@PutMapping(value = "/updateMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateMedicine(@RequestBody Medicines m) {
		return ms.updateMedicine(m);
	}

	// http://localhost:9797/medicine/deleteMedicine/3
	@DeleteMapping(value = "/deleteMedicine/{pid}")
	public String deleteUser(@PathVariable("pid") int id) {
		return ms.deleteMedicine(id);
	}

	// http://localhost:9797/medicine/getAllMedicines
	@GetMapping(value = "/getAllMedicines", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Medicines> findAllMedicines() {
		return ms.findAllMedicines();
	}

	// http://localhost:9797/medicine/findById
	@GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
	public Medicines getMedcinebyId(@RequestParam("id") int id) {
		return ms.findMedicineInfoById(id);
		// return ms.findBYI
	}

	// http://localhost:9797/medicine/findByName
	@GetMapping(value = "/findByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getMedcines(@RequestParam("input") String input) {
		return ms.getNames(input);
	}

	// http://localhost:9797/medicine/ExtractMedicine
	@GetMapping(value = "/ExtractMedicine", produces = MediaType.APPLICATION_JSON_VALUE)
	public Medicines getMedcineByName(@RequestParam("name") String name) {

		int result = ms.getIdByMedicine(name);

		if (result != 0) {
			return ms.findMedicineInfoById(result);
		} else {
			return null;
		}
	}

}

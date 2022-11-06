package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.MedicareUsers;
import com.bean.Medicines;
import com.repository.MedicinesRepository;

@Service
public class MedicinesService {

	@Autowired
	MedicinesRepository mr;

	// to configure medicines
	public String configureMedicine(Medicines m) {

		System.out.println("Input Medicine name " + m.getName());
		// if the respective medcince not present then insert else provide user defined
		// message
		if (!mr.existsByname(m.getName())) {
			mr.save(m);
			return "Medicine added " + m.getName();
		} else {
			return "Medicine name already present and provdide the different name";
		}
	}

	// Extract all medicines
	public List<Medicines> findAllMedicines() {
		return mr.findAll();
	}

	public List<String> getNames(String names) {
		System.out.println("Input passed is " + names);

		List<String> s1 = null;

		s1 = mr.getNames(names);

		if (s1.size() == 0) {
			List<String> s2 = new ArrayList<String>();
			s2.add("No Data for the provided input");
			return s2;
		} else {
			return s1; // mr.getNames(names);
		}

	}

	// update the medicine
	public String updateMedicine(Medicines m) {
		System.out.println("Medicine id from the input is " + m.getId());
		System.out.println("Medicine name from the input is " + m.getName());
		Optional<Medicines> op = mr.findById(m.getId());

		if (op.isPresent()) {
			Medicines m1 = op.get();
			m1.setPrice(m.getPrice());
			m1.setUrl(m.getUrl());
			m1.setEnableFlag(m.getEnableFlag());
			mr.saveAndFlush(m1);
			return "Medcine Details updated successfully";
		} else {
			return "Medicine not Present in the System";
		}
	}

	// delete Medicine
	public String deleteMedicine(int id) {
		Optional<Medicines> op = mr.findById(id);

		if (op.isPresent()) {
			Medicines mm = op.get();
			mr.delete(mm);
			return "Medicine Deleted";
		} else {
			return "Medicine not present";
		}
	}

	// based on Id provide the all the data out
	public Medicines findMedicineInfoById(int id) {

		Optional<Medicines> op = Optional.ofNullable(mr.findById(id).get());
		// MedicareUsers userlist = null;
		if (op.isPresent()) {
			Medicines mm = op.get();
			return mm;
		} else {
			return null; // TO-DO have to impliment exception to avoid run time exception
		}
	}

	// based on the name get the medicine name
	public Integer getIdByMedicine(String name) {

		if (mr.existsByname(name)) {
			return mr.getIdByName(name);
		} else {
			return 0;
		}
	}

}

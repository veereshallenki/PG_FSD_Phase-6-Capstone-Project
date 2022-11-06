package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicareUsers {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto
	private int id;
	private String name;
	private String email;
	private String password;
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "MedicareUsers [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", country=" + country + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MedicareUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicareUsers(int id, String name, String email, String password, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}

}

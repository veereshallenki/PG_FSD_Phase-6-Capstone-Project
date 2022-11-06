package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicines {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	private String category;
	private char enableFlag;
	private String url;

	public Medicines(int id, String name, float price, String category, char enableFlag, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.enableFlag = enableFlag;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public char getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(char enableFlag) {
		this.enableFlag = enableFlag;
	}

	@Override
	public String toString() {
		return "Medicines [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", enableFlag=" + enableFlag + ", url=" + url + "]";
	}

	public Medicines(int id, String name, float price, String category, char enableFlag) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.enableFlag = enableFlag;
	}

	public Medicines() {
		super();
		// TODO Auto-generated constructor stub
	}

}

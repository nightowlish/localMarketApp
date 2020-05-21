package com.dp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="products")
public class Product {

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productID;
	
	@Column(name="uid")
	private String uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photo_path")
	private String photoPath;
	
	@Column(name="email")
	private String email;
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", uid=" + uid + ", name=" + name + ", type=" + type
				+ ", price=" + price + ", description=" + description + ", photoPath=" + photoPath + ", email=" + email + "]";
	}

	public Product() {
		
	}

	public Product(long pID, String uid, String name, String type, int price, String description, String photoPath, String email) {
		super();
		this.productID = pID;
		this.uid = uid;
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
		this.photoPath = photoPath;
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}

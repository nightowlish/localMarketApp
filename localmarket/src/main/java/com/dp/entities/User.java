package com.dp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "hashed_password")
	private String hashedPassword;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "location")
	private String location;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", hashedPassword=" + hashedPassword + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", location=" + location + "]";
	}
	public User(int id, String first_name, String lastName, String username, String hashedPassword, String email,
			String phoneNumber, String location) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = lastName;
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}
	
	public User() {
		
	}
}

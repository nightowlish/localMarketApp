package com.dp.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dp.entities.User;
import com.dp.repositories.UserRepository;

@RestController
public class UserResource {
	
	@Autowired
	UserRepository repo;

	@GetMapping("users")
	public List<User> getUsers()
	{
		List<User> users = (List<User>) repo.findAll();
		
		return users;
	}
	
	@CrossOrigin
	@GetMapping("/api/{id}")
	public User getUserById(@PathParam("id") int id)
	{
		System.out.println("Retrieving user...");
		User u = new User();
		Optional<User> user = repo.findById(id);
		
		if(user.isPresent())
			u = user.get();
		else
			System.out.println("User not found.");
		
		return u;
	}
	
	@PostMapping("api")
	public User createUser(@RequestBody User u)
	{
		System.out.println("Creating the user...");
		System.out.println(u);
		repo.save(u);
		
		return u;
	}
	
	@DeleteMapping("delete")
	public User deleteUser(User u)
	{
		repo.delete(u);
		
		return u;
	}
	
	@PutMapping("update")
	public User updateUser(int id, String newFirstName, String newLastName, String newUsername, String newEmail, String newPhoneNumber, String newPassword, String newLocation)
	{
		User u = new User();
		Optional<User> user = repo.findById(id);
		
		//User user = Optional.ofNullable(repo.findById(id)).orElse(new User());
		
		/*user.ifPresent(us -> {
			us.setEmail(newEmail);
			us.setFirstName(newFirstName);
			us.setHashedPassword(newPassword);
			us.setLastName(newLastName);
			us.setLocation(newLocation);
			us.setPhoneNumber(newPhoneNumber);
			us.setUsername(newUsername);
			repo.save(us);
		});*/
		
		if(user.isPresent())
		{
			u = user.get();
			u.setEmail(newEmail);
			u.setFirstName(newFirstName);
			u.setHashedPassword(newPassword);
			u.setLastName(newLastName);
			u.setLocation(newLocation);
			u.setPhoneNumber(newPhoneNumber);
			u.setUsername(newUsername);
			repo.save(u);
		}
		else
		{
			System.out.println("User doesn't exist.");
		}
		
		return u;
	}
	
	
}

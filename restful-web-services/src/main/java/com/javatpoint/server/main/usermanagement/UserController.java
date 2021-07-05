package com.javatpoint.server.main.usermanagement;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController{
	
	@Autowired
	private UserDaoService userMgntService;
	
	@GetMapping("/users")
	public ArrayList<User> getUsers(){
		return userMgntService.getUsers();
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {
		User user = userMgntService.getUser(id);
		if(user == null) 
			throw new UserNotFoundException("id:"+id);
		
		return user;
	}
	
	
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable int id) {
		User user = userMgntService.getUser(id);
		if(user == null) 
			throw new UserNotFoundException("id:"+id);
		
		
		return user;
	}
	
	
	@PostMapping(path = "/addNewUser")
	public void addNewUser(@RequestBody User user) {
		userMgntService.saveUser(user);
	}
	
	@PostMapping("/users")  
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)  
	{  
	User sevedUser=userMgntService.createUser(user);    
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getUserID()).toUri();  
	return ResponseEntity.created(location).build();  
	}  
	
	@DeleteMapping(path = "/user/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = userMgntService.getUser(id);
		user = userMgntService.deleteUser(user);
		if(user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		Resource<User> resource = new Resource<User>(user);
		return user;
	}
}
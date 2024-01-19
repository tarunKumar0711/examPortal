package com.example.examPortal.controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examPortal.entity.Role;
import com.example.examPortal.entity.User;
import com.example.examPortal.entity.UserRole;
import com.example.examPortal.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService= userService;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> createUser(@RequestBody User user) throws Exception{
		
		Set<UserRole> userRoles = new HashSet<UserRole>();
		Role role= new Role(1,"NORMAL",null);
		UserRole userRole = new UserRole(1, user, role);
		userRoles.add(userRole);
		
		boolean isUserCreated = userService.createUser(user,userRoles);
		if(isUserCreated){
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User was not Created");

		}
	}
	
	
	
	@GetMapping("/getByUserName/{userName}")
	public ResponseEntity<?> getUser(@PathVariable("userName") String userName) {
		User user = userService.findByUserName(userName);
		if(Objects.nonNull(user)) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
		}
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
		this.userService.deleteUser(userId);
		return ResponseEntity.ok("Deleted User");
	}
}

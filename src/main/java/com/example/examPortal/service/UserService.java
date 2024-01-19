package com.example.examPortal.service;

import java.util.Set;

import com.example.examPortal.entity.User;
import com.example.examPortal.entity.UserRole;

public interface UserService {
	
	public boolean createUser(User user, Set<UserRole> userRoles);
	public User findByUserName(String name);
	public void deleteUser(Long userId);
	
}

package com.example.examPortal.serviceImpl;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.examPortal.entity.User;
import com.example.examPortal.entity.UserRole;
import com.example.examPortal.repositories.RolesRepository;
import com.example.examPortal.repositories.UserRepository;
import com.example.examPortal.service.UserService;

import customExceptions.DuplicateUserName;
import customExceptions.NoUserFound;
import lombok.SneakyThrows;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;

	private RolesRepository rolesRepository;

	public UserServiceImpl(UserRepository userRepository, RolesRepository rolesRepository) {
		this.userRepository = userRepository;
		this.rolesRepository = rolesRepository;
	}

	@Override
	@SneakyThrows
	public boolean createUser(User user, Set<UserRole> userRoles) {
		boolean flag = false;
		User local = this.userRepository.findByUserName(user.getUserName());
		if (Objects.nonNull(local)) {
			LOGGER.error("UserServiceimpl --> createUser() --> User with given user user name{} is already present",
					user.getUserName());
			throw new DuplicateUserName("001","Username is taken cannot allow this username");
		} else {
			userRoles.forEach(role -> {
				rolesRepository.save(role.getRole());
			});

			user.getUserRoles().addAll(userRoles);
			local = userRepository.save(user);
			flag = true;
		}
		return flag;
	}

	@Override
	public User findByUserName(String name) {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserName(name));
	    if (userOptional.isPresent()) {
	        return userOptional.get();
	    } else {
	        throw new NoUserFound("404","User not found with username: " + name);
	    }
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}

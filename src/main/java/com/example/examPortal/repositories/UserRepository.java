package com.example.examPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examPortal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);

}

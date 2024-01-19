package com.example.examPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examPortal.entity.Role;

@Repository
public interface RolesRepository  extends JpaRepository<Role,Integer>{

}

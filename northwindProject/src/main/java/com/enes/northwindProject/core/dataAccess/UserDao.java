package com.enes.northwindProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enes.northwindProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
}

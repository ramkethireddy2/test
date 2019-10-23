package com.ram.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

}

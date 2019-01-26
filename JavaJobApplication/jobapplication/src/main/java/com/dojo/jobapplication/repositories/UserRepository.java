package com.dojo.jobapplication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.jobapplication.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findAll();
	
	public User findByEmail(String email);

}

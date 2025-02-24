package com.stocker.stockerapp.service;

import com.stocker.stockerapp.entities.User;

import java.util.List;


public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(Long id) throws Exception;
	public User createUser(User user);
	public User updateUser(Long id, User user) throws Exception;
	public void deleteUser(Long id) throws Exception;


}
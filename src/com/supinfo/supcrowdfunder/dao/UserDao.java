package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.User;

public interface UserDao {
	
	User addUser(User user);
	
	User getUserById(Long userId);
	
	User getUserByEmail(String mailAddress);
	
	List<User> getAllUsers();
	
	void removeUser(User user);
	
	void removeUser(Long userId);
	
	void updateUser(User user);
	
}

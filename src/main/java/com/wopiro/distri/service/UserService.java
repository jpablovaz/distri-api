package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(Integer id);
	
	public User save(User user);
	
	public void deleteById(Integer id);

}

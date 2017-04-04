package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.UserDetails;

public interface UserDAO {
	
	public List<UserDetails> list();

	public UserDetails get(String id, String password);

	public UserDetails get(String id);

	// public void saveOrUpdate(UserDetails UserDetails);

	public boolean save(UserDetails userDetails);

	public boolean update(UserDetails userDetails);

	public void delete(String id);

	public UserDetails authenticate(String id, String name);

	public void setOnline(String userID);

	public void setOffLine(String userID);
	

	
	public UserDetails getName(String name);
	
	
	public UserDetails isValidUser(String email, String password);
	
	



}

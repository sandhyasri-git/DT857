 package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Repository
public interface UserDAO
{
	public boolean isValidate(String id,String password);
	public boolean saveOrUpdate(UserInfo user);
	public boolean delete(UserInfo user);
	public UserInfo get(int id);
	public List<UserInfo> list();
	

}

package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Sample;

@Repository
public interface CategoryDAO
{
	public Category getByName(String name);
	public void saveOrUpdate(Category category);

	public void delete(int id);

	public Category get(int id);
	public List<Sample> list();	
	
	
}

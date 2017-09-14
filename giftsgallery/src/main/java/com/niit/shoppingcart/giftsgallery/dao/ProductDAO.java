package com.niit.shoppingcart.giftsgallery.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Product;
@Repository
public interface ProductDAO
{
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(Product product);
	public Product get(int id);
	public List<Product> list();
	public boolean update(Product product);
	public Product editproduct(int prodid);
	

}

package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;

@Repository
public interface SupplierDAO {
	

	
	public boolean delete(int id);
	public Supplier get(int id);
	public List<Supplier> list();
	public void saveOrUpdate(Supplier supplier);
	public Supplier getByName(String name);
	public void update(Supplier supplier); 

}

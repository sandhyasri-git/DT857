package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Cart;

@Repository
public interface CartDAO {

	public void addcart(Cart cart);
	public  List showCart(String username);
}

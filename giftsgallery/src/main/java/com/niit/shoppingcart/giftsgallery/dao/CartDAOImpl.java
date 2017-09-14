package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.giftsgallery.model.Cart;

public class CartDAOImpl implements CartDAO {
	
	@Autowired
	 SessionFactory sessionFactory;
	public void addcart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		session.save(cart); 
		t.commit();
		session.close();

	}

	public List showCart(String username) {
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		String hql="from Cart where user=" + "'"+username+"'";
		Query query=session.createQuery(hql);
		List results= query.list();
		System.out.println(results );
		session.close();
		return results;
	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

}

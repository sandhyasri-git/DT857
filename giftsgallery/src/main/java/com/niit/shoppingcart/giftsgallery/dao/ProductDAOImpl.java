package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;


@Repository(value= "productDAO")
//@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO
{

	@Autowired
	SessionFactory sessionfactory;
	
	
	public ProductDAOImpl(SessionFactory sessionfactory)
	{
		super();
		this.sessionfactory= sessionfactory;
		
	}
	public boolean delete(Product product)
	{
	try {
	Session s = sessionfactory.getCurrentSession();
	Transaction tx = s.beginTransaction();
	s.delete(product);
	tx.commit();
	return true;
} catch (HibernateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
}
}
	@Transactional
	public List<Product> list() {
		System.out.println( "in list method");
		Session s=sessionfactory.openSession();
		Transaction tx=s.beginTransaction();
		//createCriteria is a depricated method(it helps in getting products list based on criteria)
		List<Product> list=s.createCriteria(Product.class).list();
		
		tx.commit();
		s.close();
		return list;
		
	}
	public boolean saveOrUpdate(Product product) {
		
		/*Session s=sessionfactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.saveOrUpdate(product);
		 t.commit();*/
		 sessionfactory.getCurrentSession().saveOrUpdate(product);
		 return true;	
	
	}
	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public Product get(int id) {
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		String hql = "from Product where prod_id=" +id ;
		Query query = s.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		if (list == null)

			return null;
		else {
			tx.commit();
			return list.get(0);
		}
	}
	public boolean update(Product product){  
	    /*String sql="update Product set prod_name='"+product.getProd_name()+"', quantity="+product.getQuantity()+",price="+product.getProd_price()+" where prod_id="+product.getProd_id()+"";  
	    System.out.println(sql);
	    sessionfactory.getCurrentSession().update(sql);
	    return 0;*/
		/*Session session = this.sessionfactory.getCurrentSession();
		session.update(product);*/
		try
		{
		Session s=sessionfactory.getCurrentSession();
		System.out.println("in test 2");
		s.update(product);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
		public Product editproduct(int prodid)
		{
			Session session=sessionfactory.openSession();
			Transaction t=session.beginTransaction();
			Product p=(Product)session.get(Product.class, prodid);
			return p;
		}
	}  



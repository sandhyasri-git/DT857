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
import com.niit.shoppingcart.giftsgallery.model.UserInfo;


@Repository (value= "userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean isValidate(String id, String password)
	{
		if(id.equals("bhu@gmail.com")&&password.equals("bhu"))
		{
		  // b=true;
		return true;
		}
		else
		{
		return false;
	    }
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAOImpl(SessionFactory sessionfactory)
	{
		super();
		this.sessionFactory= sessionfactory;
	}
	
	public List<UserInfo> list() {
		String hql = "from UserInfo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	public boolean delete(UserInfo user) {
		
		try {
			//sessionFactory.getCurrentSession().delete(category);
			Session s=sessionFactory.getCurrentSession();
			
			s.delete(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public UserInfo get(int id) {
		String hql = "from UserInfo where prod_id='" +id + "'";
		System.out.println("inside get");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserInfo> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}	
	
     @Transactional
    public boolean saveOrUpdate(UserInfo user) {
    	 
    		 Session s=sessionFactory.getCurrentSession();
    		 Transaction t=s.beginTransaction();
    		 s.saveOrUpdate(user);
    		 t.commit();
    		 return true;
     
        }     
}
	
	

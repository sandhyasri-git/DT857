package com.niit.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.UserDetails;

@Repository("userDAO")

public class UserDAOImpl implements UserDAO {
	
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;

	}
	@Transactional
	public UserDetails get(String id, String password) {
		String hql = "from UserDetails where user_id=" + "'"+ id+"'  and password = "
				+"'" + password + "'";
	   return getUser(hql);

	}
	@Transactional
	public UserDetails get(String id) {
		String hql = "from UserDetails where user_id=" + "'"+ id + "'" ;
		 return getUser(hql);

	}
	@Transactional
	public boolean save(UserDetails user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			System.out.println("save in user dao impl");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	@Transactional
	public void delete(String id) {
		UserDetails user = new UserDetails();
		user.setUser_id(id);
		sessionFactory.getCurrentSession().delete(user);


	}
	@Transactional
	public UserDetails authenticate(String id, String name) {
		String hql = "from UserDetails where user_id= '" + id + "' and " + " password ='" + name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	@Transactional
	public void setOnline(String userID) {
		String hql =" UPDATE UserDetails	SET isonline = 'Y' where user_id='" +  userID + "'" ;
		 
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

	}
	@Transactional
	public void setOffLine(String userID) {
		String hql =" UPDATE UserDetails	SET isonline = 'N' where user_id='" +  userID + "'" ;
		  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();


	}
	private UserDetails getUser(String hql)
	{
		
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public UserDetails getName(String name) {
		// TODO Auto-generated method stub
		String hql = "from UserDetails where user_ID=" + "'" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("username retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}
	@Transactional
	public UserDetails isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		String hql = "from UserDetails where email_id = '" + email + "' and password='" + password + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}

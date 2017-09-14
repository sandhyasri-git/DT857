package com.niit.backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Blog;

@Repository(value = "blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	public BlogDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		try {
			System.out.println(blog.getBlog_id()+" "+blog.getBlog_name());
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Blog get(String blogID) {
		// TODO Auto-generated method stub
		String hql = "from Blog where blog_id='" + blogID+"'";

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("blog retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}
	@Transactional
	public Blog getName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Blog where blog_id=" + "'" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("blogname retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}
	@Transactional
	public List<Blog> list() {
		// TODO Auto-generated method stub
		String hql = " from Blog";
		System.out.println(hql);
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
	@Transactional
	public boolean addComment(Blog blogcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public List<Blog> listComment(int id) {
		// TODO Auto-generated method stub
		String hql = " from Blog where blog_id=" + id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Transactional
	public List<Blog> listOfAllComment() {
		// TODO Auto-generated method stub
		String hql = " from BlogComment";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	

}

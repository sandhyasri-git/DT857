package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Sample;


@Repository (value= "categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
		
	
	public CategoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	 @Transactional
	   
	public void saveOrUpdate(Category category) {
		 /*Session s=sessionFactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.saveOrUpdate(category);
		 t.commit();*/
		sessionFactory.openSession().saveOrUpdate(category);
		 
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		super();
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	 @Transactional
	public Category getByName(String name) {
		 Session s=sessionFactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		String hql = "from Category where catname=" + "'"+ name +"'";
		Query query = s.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		 t.commit();
		return null;
	}

	 @Transactional
	public void delete(int id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCat_id(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);

		
	}

	 @Transactional
	public Category get(int id) {
		String hql = "from Category where cat_id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	}

	 @Transactional
	public List<Sample> list() {
		 Session s=sessionFactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		@SuppressWarnings("unchecked")
		
		/*List<Category> listCategory = (List<Category>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		*/
		//List<Category>listCategory=(List<Category>)s.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<Sample>listCategory=(List<Sample>)s.createCriteria(Sample.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		 t.commit();
		return listCategory;
		

	}
}

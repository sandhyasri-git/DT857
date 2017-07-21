package Com.Automobiles.Shopping.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import Com.Automobiles.Shopping.model.Category;

@Repository(value="categoryDAO")
//@Component
public class CategoryDAOImpl implements CategoryDAO {

	//private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public CategoryDAOImpl() {
		System.out.println("CategoryDAO Impl");
	}
	
	@Transactional
	public List<Category> list() {
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listCategory;
	}
	
	@Transactional
	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Transactional
	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}

	@Transactional
	public Category get(String id) {
		//logger.debug("calling get");
		String hql = "from Category where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//logger.debug("hql:" + hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		//logger.debug("End get");
		return null;
	}
	@Transactional
	public Category getByName(String name) {
		String hql = "from Category where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	}


	
	/*@Transactional
	public boolean save(Category category) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			s.save(category);
			tx.commit();
			//sessionFactory.getCurrentSession().save(category)
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
   /*@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
*/
	}
  /* @Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public Category get(String id) {

		String hql = "from Category where id=" + " ' " + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}
@Transactional
	public List<Category> list() {
		String hql = "from Category";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}*/




package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Supplier;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;

@Repository(value= "supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional 
	public void saveOrUpdate(Supplier supplier) {
	/*	try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	*/
		
		try {

			Session s = sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			 s.saveOrUpdate(supplier);
			//s.persist(supplier);
			System.out.println("adding supplier  impl");

			t.commit();
			s.close();

			// sessionFactory.getCurrentSession().save(supplier);

			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	//@Transactional
	public boolean delete(Supplier supplier) {
		/*try {
			Session s = sessionFactory.getCurrentSession();
	    	Transaction t = s.beginTransaction();
			//sessionFactory.getCurrentSession().delete(supplier);
	    	s.delete(supplier);
	    	t.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}*/
		
		
		
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();

			// sessionFactory.getCurrentSession().delete(product);
			s.delete(supplier);
			System.out.println("deleete suppllier...in impl");

			t.commit();

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional 
	public List<Supplier> list() {
		/*String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all=query.list();
		System.out.println("supplier list in impl");
		//tx.commit();
		//return all;
		//List<Supplier> all=sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
		System.out.println("supplier list in impl.....");
		return all;*/
		
		String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all = query.list();
		System.out.println("supplier list in impl..");
		tx.commit();
		return all;
		
	}
	
	
	@Transactional
		public Supplier get(int id) {
			Session s = sessionFactory.getCurrentSession();
	    	//Transaction tx = s.beginTransaction();
	    	
			String hql = "from Supplier where id=" +id ;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings({ "unchecked", "deprecation" }) 
			List<Supplier> list = query.list();
			for(Supplier s1:list)
			{
				System.out.println(s1.getSup_id()+"\n"+s1.getSup_name());
			}
			System.out.println("out side for loop");
			if(list == null)
				return null;
			else
			{
				//tx.commit();
				System.out.println("suppliet get method in impl....");
				return list.get(0);
			}
	}
	
			
		
		/*String hql = "from Supplier where id=" + id;
	        // hibernate query
	        Session s = sessionFactory.getCurrentSession();
			//Transaction t = s.beginTransaction();
	        Query query = s.createQuery(hql);
	        //Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        List<Supplier>list = query.list();
			 //t.commit();
			if (list == null) {
				return null;
				} else 
				{
	           System.out.println("geeeet supplier in impl");
	           return list.get(0);
	           }
	}*/
		
		
		
		
	
	@Transactional
	public void update(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(supplier);
			System.out.println("update supplier in impl");
			tx.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/*sessionFactory.getCurrentSession().update(supplier);
		return true;}*/
		
		/*try{
			  sessionFactory.getCurrentSession().update(supplier);
			  return true;
			  }
		catch(Exception e){ 
		e.printStackTrace(); 
		return false; 
		} 
		
	}
	*/
	
	public Supplier getByName(String name) {
		 Session s=sessionFactory.openSession();
		 Transaction t=s.beginTransaction();
		String hql = "from Supplier where sup_name=" + "'"+ name +"'";
		Query query = s.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		 t.commit();
		 s.close();
		return null;
}
/*//	@Transactional
//	public Supplier get(int id) {
//		{
//			// TODO Auto-generated method stub
//	        String hql = "from Supplier where id= " + " ' " + id + " ' ";  //category is d domain object name not table name
//			Query query = sessionFactory.getCurrentSession().createQuery(hql);
//			List <Supplier> list = query.list();
//			return null;
//		}
//	}

	
	/*@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionfactory.getCurrentSession().saveOrUpdate(supplier);
	}


	public SupplierDAOImpl() {
		
		// TODO Auto-generated constructor stub
	}

	public SupplierDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public boolean delete(int id) {
		Supplier supplier = new Supplier();
		supplier.setSup_id(id);
		try {
			sessionfactory.getCurrentSession().delete(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return true;
			
		}
		return false;

	}

	public Supplier get(int id) {
		
		String hql = "from Supplier where sup_id=" + "'"+ id+"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;

	}

	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) sessionfactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		List<Supplier>list=s.createCriteria(Supplier.class).list();
		return list;
	}

	
	@Transactional
	public Supplier getByName(String name) {
		String hql = "from Supplier where sup_name=" + "'"+ name+"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	public void update(Supplier s2) {
		Supplier s1=new Supplier();
		s1=getByName(s2.getSup_name());
		System.out.println(s1.getSup_id());
		if(s1!=null)
		{
			s1.setSup_id(s2.getSup_id());
			s1.setSup_name(s2.getSup_name());
			s1.setSup_description(s2.getSup_name());
		}
		
		
	}

*/
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

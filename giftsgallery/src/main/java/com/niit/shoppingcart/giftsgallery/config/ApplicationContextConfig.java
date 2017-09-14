package com.niit.shoppingcart.giftsgallery.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.giftsgallery.dao.CartDAO;
import com.niit.shoppingcart.giftsgallery.dao.CartDAOImpl;
import com.niit.shoppingcart.giftsgallery.dao.CategoryDAO;
import com.niit.shoppingcart.giftsgallery.dao.CategoryDAOImpl;
import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.dao.ProductDAOImpl;
import com.niit.shoppingcart.giftsgallery.dao.SupplierDAO;
import com.niit.shoppingcart.giftsgallery.dao.SupplierDAOImpl;
import com.niit.shoppingcart.giftsgallery.dao.UserDAO;
import com.niit.shoppingcart.giftsgallery.dao.UserDAOImpl;
import com.niit.shoppingcart.giftsgallery.model.Cart;
import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Sample;
import com.niit.shoppingcart.giftsgallery.model.Supplier;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class ApplicationContextConfig 
{
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/bhumika"); 
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    
	    System.out.println("data source");
	 
	    return dataSource;
	}
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    properties.put("hibernate.current_session_context_class","thread");
	    
	    System.out.println("properties");
		 
	    return properties;
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	/*  
	   
	   sessionBuilder.addAnnotatedClasses(CartItem.class);
	   sessionBuilder.addAnnotatedClasses(Customer.class);
	*/   
	   sessionBuilder.addAnnotatedClasses(UserInfo.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	sessionBuilder.addAnnotatedClasses(Category.class);
	   sessionBuilder.addAnnotatedClasses(Cart.class);
	    sessionBuilder.addAnnotatedClasses(Supplier.class);
	    sessionBuilder.addAnnotatedClasses(Cart.class);
		  
	   System.out.println("session factory");
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager
	        (SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager
	    		    (sessionFactory);
	 
	    return transactionManager;
	}
	   @Autowired
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		    
		 
		    return new CategoryDAOImpl( sessionFactory);
		}
	    @Autowired
	    @Bean(name="category")
	    public Category getCategory()
	    {
	    	return new Category();
	    }

	    @Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		    
		 
		    return new SupplierDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="supplier")
	    public Supplier getSupplier()
	    {
	    	return new Supplier();
	    	}
	    
	
	//User
	
	 @Autowired
		@Bean(name="userDAO")
		public UserDAO getUserDAO(SessionFactory sessionFactory)
	    {
		    
		  System.out.println("user dao");
		    return new UserDAOImpl(sessionFactory);
		}
	   /* @Autowired
	    @Bean(name="userinfo")
	    public UserInfo getUser()
	    {
	    	System.out.println("user ");
			 
	    	return new UserInfo();
	    }
*/


	//Product
	    
	    @Autowired
		@Bean(name="productDAO")
		public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		    
	    	System.out.println("product dao ");
			
		    return new ProductDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="product")
	    public Product getProduct()
	    {
	    	System.out.println("product ");
			
	    	return new Product();
	    
	    }
	    @Autowired
		@Bean(name="cartDAO")
		public CartDAO getCartDAO(SessionFactory sessionFactory) {
		    
	    	System.out.println("cart dao ");
			
		    return new CartDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="cart")
	    public Cart getCart()
	    {
	    	System.out.println("Sample ");
			
	    	return new Cart();
	    
	    }
	    }
     
	    
	    

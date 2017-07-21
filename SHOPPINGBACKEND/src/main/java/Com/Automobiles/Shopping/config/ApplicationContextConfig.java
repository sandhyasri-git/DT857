package Com.Automobiles.Shopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Com.Automobiles.Shopping.dao.CategoryDAO;
import Com.Automobiles.Shopping.dao.CategoryDAOImpl;
import Com.Automobiles.Shopping.dao.ProductDAO;
import Com.Automobiles.Shopping.dao.ProductDAOImpl;
import Com.Automobiles.Shopping.dao.UserDetailsDAO;
import Com.Automobiles.Shopping.dao.UserDetailsDAOImpl;
import Com.Automobiles.Shopping.model.Category;
import Com.Automobiles.Shopping.model.Product;
import Com.Automobiles.Shopping.model.Supplier;
import Com.Automobiles.Shopping.model.UserDetails;

@Configuration
@ComponentScan("Com.Automobiles")
@EnableTransactionManagement

public class ApplicationContextConfig {
    
	/*@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("getData Source");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/hyd"); 
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}
	private Properties getHibernateProperties() {
		System.out.println("getHibernate Source");
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.hbm2ddl.auto","update");
	   properties.put("hibernate.current_session_context_class","thread");
	    return properties;
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	   sessionBuilder.addProperties(getHibernateProperties());
	// sessionBuilder.scanPackages("Com.Automobiles.Shopping");
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    //sessionBuilder.addAnnotatedClass(Supplier.class);
	    sessionBuilder.addAnnotatedClass(Product.class);
	 
	     System.out.println("annotated class begin");
	    sessionBuilder.addAnnotatedClass(UserDetails.class);
	   
	    sessionBuilder.addProperties(getHibernateProperties());
	    System.out.println("class created");
	    return sessionBuilder.buildSessionFactory();
	}
		
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	    System.out.println("in transaction Manager method");
	    return transactionManager;
	}
	
	
	/*@Autowired
	@Bean(name="category")
	public Category getCategory() {
		return new Category();
	}
	
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getcategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
		
	}
	@Autowired
	@Bean(name="product")
	public Product getProduct(){
		return new Product();
		
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getproductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userdetailsDAO")
	public UserDetailsDAO getuserDetailsDAO(SessionFactory sessionFactory)
	{
		return new UserDetailsDAOImpl(sessionFactory);
		
	}

	@Autowired
	@Bean(name="userdetails")
	
		public UserDetails getUserDetails()
		{
		
	return new UserDetails();
		}

	*/
	@Bean(name = "h2DataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/hyd");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		return dataSource;
	}
    
    /*@Bean(name = "dataSource")
    public DataSource getMySQLDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/niitdb");
    	dataSource.setUsername("root");
    	dataSource.setPassword("root");
    	
    	
    	
    	return dataSource;
    }*/
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
    	//sessionBuilder.addAnnotatedClasses(Cart.class);
    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
    	//sessionBuilder.addAnnotatedClasses(Account.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
    @Autowired
    @Bean(name = "categoryDao")
    public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }
    
   /* @Autowired
    @Bean(name = "cartDao")
    public CartDAO getCartDao(SessionFactory sessionFactory) {
    	return new CartDAOImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "accountDAO")
    public AccountDAO getAccountDao(SessionFactory sessionFactory) {   //returned CartDAO from this method ... error
    	return new AccountDAOImpl(sessionFactory);
    }
	*/

	}
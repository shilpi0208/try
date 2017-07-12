package com.Mobitel.MobitelBack.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Mobitel.MobitelBack.dao.CartDAO;
import com.Mobitel.MobitelBack.dao.CategoryDAO;
import com.Mobitel.MobitelBack.dao.OrderDAO;
import com.Mobitel.MobitelBack.dao.ProductDAO;
import com.Mobitel.MobitelBack.dao.SupplierDAO;
import com.Mobitel.MobitelBack.dao.UserDAO;
import com.Mobitel.MobitelBack.model.Cart;
import com.Mobitel.MobitelBack.model.Category;
import com.Mobitel.MobitelBack.model.Order;
import com.Mobitel.MobitelBack.model.Product;
import com.Mobitel.MobitelBack.model.Supplier;
import com.Mobitel.MobitelBack.model.User;






@Configuration
@ComponentScan("com.Mobitel.MobitelBack")
@EnableTransactionManagement
public class DBConfig 
{

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() 
	{
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		System.out.println("---Hibernate Properties----");
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); //optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");
		
		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("---Factory Builder Object Created---");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		
	
		sessionBuilder.addAnnotatedClass(Product.class);
		
		System.out.println("Session Factory Object Creation");
		SessionFactory sessionFactory = null;
		try{
			sessionFactory=sessionBuilder.buildSessionFactory();
		}catch(Exception e){
			System.out.println("EXP : "+ e);
		}
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--Transaction manager Object Creation--");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("--Transaction manager Object Created--");
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- CategoryDAO Object Creation--");
		return new CategoryDAO(sessionFactory);
	}
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- SupplierDAO Object Creation--");
		return new SupplierDAO(sessionFactory);
	}

	

	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- ProductDAO Object Creation--");
		return new ProductDAO(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- UserDAO Object Creation--");
		return new UserDAO(sessionFactory);
	}
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- cartDAO Object Creation--");
		return new CartDAO(sessionFactory);
	}
	@Autowired
	@Bean(name="orderDAO")
	public OrderDAO getOrderDAO(SessionFactory sessionFactory)
	{
		System.out.println("-- userDAO Object Creation--");
		return new OrderDAO(sessionFactory);
	}

}
package com.Mobitel.MobitelBack.dao;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Mobitel.MobitelBack.model.Order;



@Repository("orderDAO")

public class OrderDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateOrder(Order order)
	{
		Session session=sessionFactory.getCurrentSession();
		System.out.println("####in save ");
		session.saveOrUpdate(order);
		
	}
	
	public Order getOrder(int orderid)
	{
		Session session=sessionFactory.openSession();
		Order order=(Order)session.get(Order.class,orderid);
	
		return order;
	}

	@Transactional
	public void deleteOrder(Order order)
	{
		sessionFactory.getCurrentSession().delete(order);
	}
	
	public List<Order> getOrderDetails(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Order  where username=:username");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Order> list=query.list();
		session.close();
		return list;
	}

	
	
	
	
}
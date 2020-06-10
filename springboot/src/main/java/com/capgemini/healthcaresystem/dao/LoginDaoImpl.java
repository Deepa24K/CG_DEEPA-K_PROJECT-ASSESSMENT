package com.capgemini.healthcaresystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.bean.LoginBean;
import com.capgemini.healthcaresystem.exception.LoginException;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public LoginBean login(LoginBean loginBean) {
		EntityManager manager=	factory.createEntityManager();
		String jpql = "from LoginBean where email= :email";
		TypedQuery<LoginBean> query = manager.createQuery(jpql,LoginBean.class);
		query.setParameter("email", loginBean.getEmail());
		try {
			LoginBean bean=query.getSingleResult();
	  
		if(loginBean.getPassword().equals(bean.getPassword())) {
		return bean;
		}else {
			throw new LoginException("Password Invalid ");
		}
		}catch (Exception e) {
			throw new LoginException("The email address that you've entered doesn't match with any account");	
		}
	}

	@Override
	public boolean signup(LoginBean loginBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(loginBean);
		transaction.commit();
		return true;
		}catch(Exception e) {
			
		}
		throw new LoginException("This ID already exists");
	}

	@Override
	public boolean updatePassword(LoginBean loginBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		try {
			LoginBean bean=manager.find(LoginBean.class, loginBean.getLoginId());
			if(bean!=null) {
				if(bean.getRole().equalsIgnoreCase("admin")) {
			transaction.begin();
			bean.setPassword(loginBean.getPassword());
			transaction.commit();
			return true;
				}
			}
		}catch(Exception e) {
			
		}
		throw new LoginException("Invalid Crentials");
		}

	@Override
	public boolean deleteAccount(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		LoginBean loginDetails=manager.find(LoginBean.class, id);
		if(loginDetails!= null) {
			manager.remove(loginDetails);
			transaction.commit();
			return true;
		}
		throw new LoginException("Invalid Credentials");
	}

	}

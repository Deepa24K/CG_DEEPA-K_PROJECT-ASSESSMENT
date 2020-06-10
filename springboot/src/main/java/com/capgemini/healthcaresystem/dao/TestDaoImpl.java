package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;
import com.capgemini.healthcaresystem.bean.TestBean;
import com.capgemini.healthcaresystem.exception.CenterException;
import com.capgemini.healthcaresystem.exception.TestException;

@Repository
public class TestDaoImpl implements TestDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addTest(TestBean testBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(testBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean removeTest(String centerId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql="delete from TestBean where centerId= :testId";
		Query query=manager.createQuery(jpql);
		query.setParameter("id", centerId);
		int i=query.executeUpdate();
		transaction.commit();
		if(i>0) {
			return true;
		}
		throw new TestException("Unable to delete");
	}

	@Override
	public List<TestBean> getAllTests() {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql= "from TestBean";
		Query query=manager.createQuery(jpql);
		try {
		List<TestBean> list=query.getResultList();
		if(list!=null) {
			return list;
		}
		}catch (Exception e) {
			
		}
		throw new TestException("Currently No Tests Available");
	}

	@Override
	public boolean modifyTest(int testId, String testName, String centerId) {
		EntityManager manager =null;
		EntityTransaction transaction = null;
		
		try{
		 manager=factory.createEntityManager();
		 transaction = manager.getTransaction();
		transaction.begin();
		TestBean bean= manager.find(TestBean.class, testId);
		bean.setTestId(testId);
		bean.setTestName(testName);
		bean.setCenterId(centerId);
		transaction.commit();
	}catch(Exception e) {
		transaction.rollback();
		throw new TestException("Test Details not updated");
	}
		manager.close();
		return true;
	}
}

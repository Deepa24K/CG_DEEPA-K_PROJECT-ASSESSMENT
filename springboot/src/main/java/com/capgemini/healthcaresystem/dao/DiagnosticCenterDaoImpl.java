package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;
import com.capgemini.healthcaresystem.exception.CenterException;

@Repository
public class DiagnosticCenterDaoImpl implements DiagnosticCenterDao{

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addCenter(DiagnosticCenterBean centerBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(centerBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

		}
		throw new CenterException("Diagnostic Center with the same Id has already added");
	}

	@Override
	public List<DiagnosticCenterBean> getAllCenters() {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql= "from DiagnosticCenterBean";
		Query query=manager.createQuery(jpql);
		try {
		List<DiagnosticCenterBean> list=query.getResultList();
		if(list!=null) {
			return list;
		}
		}catch (Exception e) {
			
		}
		throw new CenterException("Currently No Centers Available");
	}

	@Override
	public boolean modifyCenter(DiagnosticCenterBean centerBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();

		DiagnosticCenterBean bean= manager.find(DiagnosticCenterBean.class, centerBean.getCenterId());
		if(bean!=null) {
			transaction.begin();
		bean.setCenterId(centerBean.getCenterId());
		bean.setCenterName(centerBean.getCenterName());
		transaction.commit();
		return true;
		}else {
			
			throw new CenterException("Invalid ID");
		}
	}

	@Override
	public List<DiagnosticCenterBean> searchCenter(String centerId) {
		String jpql= "from DiagnosticCenterBean where centerId=:id";
		EntityManager manger = factory.createEntityManager();
		TypedQuery<DiagnosticCenterBean> query=manger.createQuery(jpql, DiagnosticCenterBean.class);
		query.setParameter("id", centerId);
		try {
		if(query!=null) {
		return query.getResultList();
		}
		}catch (Exception e) {
			
		}
		throw new CenterException("Invalid ID");
	}

	@Override
	public boolean removeCenter(String centerId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql="delete from DiagnosticCenterBean where centerId= :id";
		Query query=manager.createQuery(jpql);
		query.setParameter("id", centerId);
		int i=query.executeUpdate();
		transaction.commit();
		if(i>0) {
			return true;
		}
		throw new CenterException("Unable to delete");
	}
}

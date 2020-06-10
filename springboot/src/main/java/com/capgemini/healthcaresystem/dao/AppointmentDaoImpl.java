package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.bean.AppointmentBean;
import com.capgemini.healthcaresystem.exception.AppointmentException;
@Repository
public class AppointmentDaoImpl implements AppointmentDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean deleteAppointment(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		AppointmentBean bean=manager.find(AppointmentBean.class,id);
		if(bean!= null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
	
		throw new AppointmentException("Invalid ID");
	}

	@Override
	public List<AppointmentBean> getAllAppointments() {
		String jpql= "from AppointmentBean";
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		List<AppointmentBean> list=query.getResultList();
		if(list!=null) {
			return list;
		}
		throw new AppointmentException("Currently No Appointments are Available");
	}

	@Override
	public boolean modifyAppointment(AppointmentBean appointmentBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();

		AppointmentBean bean= manager.find(AppointmentBean.class, appointmentBean.getAppointmentId());
		if(bean!=null) {
			transaction.begin();
		bean.setAppointmentDate(appointmentBean.getAppointmentDate());
		bean.setAppointmentTime(appointmentBean.getAppointmentTime());
		bean.setStatus(appointmentBean.getStatus());
		transaction.commit();
		return true;
		}else {
			
			throw new AppointmentException("Invalid ID");
		}
	}

}

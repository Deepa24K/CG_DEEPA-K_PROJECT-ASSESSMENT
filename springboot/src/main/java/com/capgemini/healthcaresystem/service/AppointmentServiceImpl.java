package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.bean.AppointmentBean;
import com.capgemini.healthcaresystem.dao.AppointmentDao;
@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public boolean deleteAppointment(int id) {
		return appointmentDao.deleteAppointment(id);
	}

	@Override
	public List<AppointmentBean> getAllAppointments() {
		return appointmentDao.getAllAppointments();
	}

	@Override
	public boolean modifyAppointment(AppointmentBean appointmentBean) {
		return appointmentDao.modifyAppointment(appointmentBean);
	}

}

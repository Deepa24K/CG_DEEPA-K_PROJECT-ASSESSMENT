package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.bean.AppointmentBean;

public interface AppointmentDao {
	public boolean deleteAppointment(int id);
	public List<AppointmentBean> getAllAppointments();
	public boolean modifyAppointment(AppointmentBean appointmentBean);
}

package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.bean.AppointmentBean;

public interface AppointmentService {
	public boolean deleteAppointment(int id);
	public List<AppointmentBean> getAllAppointments();
	public boolean modifyAppointment(AppointmentBean appointmentBean);
}

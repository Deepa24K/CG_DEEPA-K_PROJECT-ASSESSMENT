package com.capgemini.healthcaresystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.bean.AppointmentBean;
import com.capgemini.healthcaresystem.bean.AppointmentResponse;
import com.capgemini.healthcaresystem.service.AppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*" , allowCredentials = "true")
@RestController
public class Appointment {
	@Autowired
	private AppointmentService appointmentService;
	
	@DeleteMapping(path="/delete-appointment/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse deleteAppointment(@PathVariable("id")int id) {
		AppointmentResponse response= new AppointmentResponse();
		appointmentService.deleteAppointment(id);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDiscription("Appointment Successfully Deleted");	
		return response;
	}
	@GetMapping(path="/getallappointments",produces=MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppointments() {
		AppointmentResponse response= new AppointmentResponse();
		List<AppointmentBean> beans = appointmentService.getAllAppointments();
		if(beans.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Appointment deatils Not Found");	
			}else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Appointment Details Found");
			response.setBeans(beans);
		}
		return response;
	}
	
	@PutMapping(path="/modify-appointment",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse modifyAppointment(@RequestBody AppointmentBean bean) {
		AppointmentResponse response= new AppointmentResponse();
		if(appointmentService.modifyAppointment(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription(" Successfully Modified Appointment");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Failed to modify Appointment");	
		}
		return response;
	}
	
}

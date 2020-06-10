package com.capgemini.healthcaresystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.bean.AppointmentResponse;
import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;
import com.capgemini.healthcaresystem.bean.DiagnosticResponse;
import com.capgemini.healthcaresystem.service.DiagnosticCenterService;

@CrossOrigin(origins = "*", allowedHeaders = "*" , allowCredentials = "true")
@RestController
public class DiagnosticCenter {
	@Autowired
	private DiagnosticCenterService centerService;
	
	@PostMapping(path="/add-center",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticResponse  addCenter(@RequestBody DiagnosticCenterBean centerBean) {
		DiagnosticResponse response= new DiagnosticResponse();
		if(centerService.addCenter(centerBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Successfully Added Diagnostic Center");
		}
		return response;
	}
	@DeleteMapping(path="/remove-center/{centerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticResponse removeCenter(@PathVariable("centerId") String centerId) {
		DiagnosticResponse response= new DiagnosticResponse();
		centerService.removeCenter(centerId);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDiscription("Diagnostic Center Successfully Deleted");	
		return response;
	}
	@GetMapping(path="/getall-centers",produces=MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticResponse getAllCenters() {
		DiagnosticResponse response= new DiagnosticResponse();
		List<DiagnosticCenterBean> beans = centerService.getAllCenters();
		if(beans.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Unable to find list of centers");	
			}else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Diagnostic list found");
			response.setBeans(beans);
		}
		return response;
	}
	@PutMapping(path="/modify-center",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticResponse modifyCenter(@RequestBody DiagnosticCenterBean centerBean) {
		DiagnosticResponse response= new DiagnosticResponse();
		if(centerService.modifyCenter(centerBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription(" Successfully Modified Center");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Failed to modify Center");	
		}
		return response;
	}
	@GetMapping(path="/search-center/{key}",produces=MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticResponse searchCenter(@PathVariable("key")String key) {
		DiagnosticResponse response= new DiagnosticResponse();
		List<DiagnosticCenterBean> beans = centerService.searchCenter(key);
		if(beans.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Appointment details not Found");	
			}else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Appointment Details Found");
			response.setBeans(beans);
		}
		return response;
	}
}

package com.capgemini.healthcaresystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.bean.LoginBean;
import com.capgemini.healthcaresystem.bean.LoginResponse;
import com.capgemini.healthcaresystem.dao.LoginDao;

@CrossOrigin(origins = "*", allowedHeaders = "*" , allowCredentials = "true")
@RestController
public class Login {
	@Autowired
	private LoginDao loginDao;
	
	@PostMapping(path="/login", produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse Login(@RequestBody LoginBean bean) {
		LoginBean Bean= loginDao.login(bean);
	
	LoginResponse response= new LoginResponse();
		if(Bean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Successfully LoggedIn");
			response.setBeans(Arrays.asList(Bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Invalid credentials");
		}
		return response;
	}
	@PostMapping(path="/register",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse  signup(@RequestBody LoginBean bean) {
		LoginResponse response= new LoginResponse();
		if(loginDao.signup(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Registered Successful");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Failed to Register");	
		}
		return response;
	}
	
	@DeleteMapping(path="/account-delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse accountDelete(@PathVariable("id")int id) {
		LoginResponse response= new LoginResponse();
		loginDao.deleteAccount(id);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDiscription("Successfully Deleted Account");	
		return response;
	}

	
	@PutMapping(path="/login-modify",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse updatePassword(@RequestBody LoginBean bean) {
		LoginResponse response= new LoginResponse();
		if(loginDao.updatePassword(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription(" successfully Modified Password");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Failed to change Password");	
		}
		return response;
	}
}

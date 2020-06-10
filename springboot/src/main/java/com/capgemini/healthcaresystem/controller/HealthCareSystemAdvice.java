package com.capgemini.healthcaresystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.healthcaresystem.bean.DiagnosticResponse;
import com.capgemini.healthcaresystem.bean.LoginResponse;
import com.capgemini.healthcaresystem.bean.TestResponse;
import com.capgemini.healthcaresystem.exception.CenterException;
import com.capgemini.healthcaresystem.exception.LoginException;
import com.capgemini.healthcaresystem.exception.TestException;

@RestControllerAdvice
public class HealthCareSystemAdvice {
	@ExceptionHandler(CenterException.class)
	public DiagnosticResponse handleContractException(CenterException e) {
		DiagnosticResponse response = new DiagnosticResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDiscription(e.getMessage());
		return response;
	}
	
	@ExceptionHandler(TestException.class)
	public TestResponse handleContractException(TestException e) {
		TestResponse response = new TestResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDiscription(e.getMessage());
		return response;
	}
	@ExceptionHandler(LoginException.class)
	public LoginResponse handleContractException(LoginException e) {
		LoginResponse response = new LoginResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDiscription(e.getMessage());
		return response;
	}
}

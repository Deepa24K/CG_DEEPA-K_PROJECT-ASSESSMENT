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

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;
import com.capgemini.healthcaresystem.bean.DiagnosticResponse;
import com.capgemini.healthcaresystem.bean.TestBean;
import com.capgemini.healthcaresystem.bean.TestResponse;
import com.capgemini.healthcaresystem.service.TestService;

@CrossOrigin(origins = "*", allowedHeaders = "*" , allowCredentials = "true")
@RestController
public class Test {
	
	@Autowired
	private TestService testService;
	
	
	@PostMapping(path="/add-test",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public TestResponse  addTest(@RequestBody TestBean testBean) {
		TestResponse response= new TestResponse();
		if(testService.addTest(testBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Successfully Added Test");
		}
		return response;
	}
	@DeleteMapping(path="/remove-test/{centerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public TestResponse removeTest(@PathVariable("centerId")  String centerId) {
		TestResponse response= new TestResponse();
		if(testService.removeTest(centerId)){
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Test Successfully Deleted");	
		}
		return response;
	}
	@GetMapping(path="/getall-tests",produces=MediaType.APPLICATION_JSON_VALUE)
	public TestResponse getAllTests() {
		TestResponse response= new TestResponse();
		List<TestBean> beans = testService.getAllTests();
		if(beans.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Unable to find list of tests");	
			}else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription("Test list found");
			response.setBeans(beans);
		}
		return response;
	}
	@PutMapping(path="/modify-test",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public TestResponse modifyTest(@RequestBody TestBean bean) {
		TestResponse response= new TestResponse();
		if(testService.modifyTest(bean.getTestId(),bean.getTestName(),bean.getCenterId())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDiscription(" Successfully Modified Test");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDiscription("Failed to modify Test");	
		}
		return response;
	}

}

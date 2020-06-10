package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.bean.TestBean;

public interface TestService {
	public boolean addTest(TestBean testBean);
	public boolean removeTest(String centerId);
	public List<TestBean> getAllTests();
	public boolean modifyTest(int testId, String testName, String centerId);
}

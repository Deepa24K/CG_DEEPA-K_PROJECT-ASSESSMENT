package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.bean.TestBean;
import com.capgemini.healthcaresystem.dao.TestDao;
@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;
	
	@Override
	public boolean addTest(TestBean testBean) {
		return testDao.addTest(testBean);
	}

	@Override
	public boolean removeTest(String centerId) {
		return testDao.removeTest(centerId);
	}

	@Override
	public List<TestBean> getAllTests() {
		return testDao.getAllTests();
	}

	@Override
	public boolean modifyTest(int testId, String testName, String centerId) {
		return testDao.modifyTest(testId, testName, centerId);
	}

}

package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.bean.TestBean;

public interface TestDao {
public boolean addTest(TestBean testBean);
public boolean removeTest(String centerId);
public List<TestBean> getAllTests();
public boolean modifyTest(int testId, String testName, String centerId);
}
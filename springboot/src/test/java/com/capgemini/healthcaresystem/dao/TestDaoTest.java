package com.capgemini.healthcaresystem.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcaresystem.bean.TestBean;
@SpringBootTest
public class TestDaoTest {

	@Autowired
	TestDao dao;
	
  @Test
  public void addTest() {
	  TestBean bean1=new TestBean();
	  
	  	bean1.setCenterId("4");
		bean1.setTestName("xray");
		boolean added= dao.addTest(bean1);
		assertTrue(added);
		dao.removeTest(bean1.getCenterId());
  }

  @Test
  public void getAllTests() {
	  assertNotNull(dao.getAllTests());
  }

  @Test
  public void removeTest() {
	  TestBean bean2=new TestBean();
		
		bean2.setCenterId("2");
		bean2.setTestName("Name");
		dao.addTest(bean2);
		assertTrue(dao.removeTest(bean2.getCenterId()));
  }
}

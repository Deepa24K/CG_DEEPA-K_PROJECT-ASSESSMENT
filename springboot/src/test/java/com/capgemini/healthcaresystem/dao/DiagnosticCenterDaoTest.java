package com.capgemini.healthcaresystem.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;

@SpringBootTest
public class DiagnosticCenterDaoTest {

	@Autowired
	DiagnosticCenterDao  dao;

	
  @Test
  public void addCenter() {
	  DiagnosticCenterBean bean1=new DiagnosticCenterBean();
		
		bean1.setCenterId("4");
		bean1.setCenterName("Centers");
		boolean added= dao.addCenter(bean1);
		assertTrue(added);
		dao.removeCenter(bean1.getCenterId());
  }

  @Test
  public void getAllCenters() {
	  assertNotNull(dao.getAllCenters());
  }

  @Test
  public void removeCenter() {
	  DiagnosticCenterBean bean2=new DiagnosticCenterBean();
		
		bean2.setCenterId("2");
		bean2.setCenterName("Name");
		dao.addCenter(bean2);
		assertTrue(dao.removeCenter(bean2.getCenterId()));
  }

  @Test
  public void searchCenter() {
	  DiagnosticCenterBean bean3=new DiagnosticCenterBean();
	  bean3.setCenterId("2");
	  bean3.setCenterName("Name");
		dao.addCenter(bean3);
		assertNotNull(dao.searchCenter(bean3.getCenterId()));
		dao.removeCenter(bean3.getCenterId());
  }
}

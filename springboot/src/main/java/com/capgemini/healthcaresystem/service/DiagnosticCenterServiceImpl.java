package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;
import com.capgemini.healthcaresystem.bean.TestBean;
import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dao.TestDao;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{

	@Autowired
	private DiagnosticCenterDao centerDao;

	@Autowired
	private TestDao testDao;

	@Override
	public boolean addCenter(DiagnosticCenterBean centerBean) {
		boolean add= centerDao.addCenter(centerBean);

		String c1=centerBean.getCenterId();

		TestBean t1=new TestBean();
		t1.setCenterId(c1);
		t1.setTestName("Blood-sugar");
		testDao.addTest(t1);

	TestBean t2=new TestBean();
		t2.setCenterId(c1);
		t2.setTestName("Blood-pressure");
		testDao.addTest(t2);

		TestBean t3=new TestBean();
		t3.setCenterId(c1);
		t3.setTestName("Blood-group");
		testDao.addTest(t3);
		return add;
	}

//	@Override
//	public boolean removeCenter(DiagnosticCenterBean centerBean) {
//		boolean remove = centerDao.removeCenter(centerBean);
//		TestBean t4=new TestBean();
//		t4.setCenterId(centerBean.getCenterId());
//		testDao.removeTest(t4);
//		return remove;
//	}

	@Override
	public List<DiagnosticCenterBean> getAllCenters() {
		return centerDao.getAllCenters();
	}

	@Override
	public boolean modifyCenter(DiagnosticCenterBean centerBean) {
		return centerDao.modifyCenter(centerBean);
	}

	@Override
	public List<DiagnosticCenterBean> searchCenter(String centerId) {
		return centerDao.searchCenter(centerId);
	}

	@Override
	public boolean removeCenter(String centerId) {
		testDao.removeTest(centerId);
		return centerDao.removeCenter(centerId);
	}
}

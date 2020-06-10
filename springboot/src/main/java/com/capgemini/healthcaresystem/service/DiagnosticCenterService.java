package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;

public interface DiagnosticCenterService {
	public boolean addCenter(DiagnosticCenterBean centerBean);
//	public boolean removeCenter(DiagnosticCenterBean centerBean);
	public List<DiagnosticCenterBean> getAllCenters();
	public boolean modifyCenter(DiagnosticCenterBean centerBean);
	public List<DiagnosticCenterBean> searchCenter(String centerId);
	public boolean removeCenter(String centerId);
}

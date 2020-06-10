package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.bean.DiagnosticCenterBean;

public interface DiagnosticCenterDao {
	public boolean addCenter(DiagnosticCenterBean centerBean);
	public List<DiagnosticCenterBean> getAllCenters();
	public boolean modifyCenter(DiagnosticCenterBean centerBean);
	public List<DiagnosticCenterBean> searchCenter(String centerId);
	public boolean removeCenter(String centerId);
}

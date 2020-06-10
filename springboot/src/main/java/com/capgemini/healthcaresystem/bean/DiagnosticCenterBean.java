package com.capgemini.healthcaresystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DiagnosticCenterBean {

	@Id
	@Column
	private String centerId;
	@Column
	private String centerName;
	
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	@Override
	public String toString() {
		return "DiagnosticCenterBean [centerId=" + centerId + ", centerName=" + centerName + "]";
	}
}

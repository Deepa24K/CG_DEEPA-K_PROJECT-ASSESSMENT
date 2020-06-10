package com.capgemini.healthcaresystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TestBean {
	@Id
	@Column
	@GeneratedValue
	private int testId;
	@Column
	private String testName;
	@Column
	private String centerId;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	@Override
	public String toString() {
		return "TestBean [testId=" + testId + ", testName=" + testName + ", centerId=" + centerId + "]";
	}
	
	
}

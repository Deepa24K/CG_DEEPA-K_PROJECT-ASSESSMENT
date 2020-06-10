package com.capgemini.healthcaresystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AppointmentBean {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int appointmentId;
	@Column
	private String userId;
	@Column
	private String userName;
	@Column
	private String testId;
	@Column
	private String testName;
	@Column
	private String centerId;
	@Column
	private String centerName;
	@Column
	private String AppointmentDate;
	@Column
	private String AppointmentTime;
	@Column
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return AppointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		AppointmentTime = appointmentTime;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
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
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	@Override
	public String toString() {
		return "AppointmentBean [appointmentId=" + appointmentId + ", userId=" + userId + ", userName=" + userName
				+ ", testId=" + testId + ", testName=" + testName + ", centerId=" + centerId + ", centerName="
				+ centerName + ", AppointmentDate=" + AppointmentDate + ", AppointmentTime=" + AppointmentTime
				+ ", status=" + status + "]";
	}



}

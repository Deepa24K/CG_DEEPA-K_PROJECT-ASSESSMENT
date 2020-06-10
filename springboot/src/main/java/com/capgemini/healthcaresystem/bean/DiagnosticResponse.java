package com.capgemini.healthcaresystem.bean;

import java.util.List;

public class DiagnosticResponse {
	private int statusCode;
	private String message;
	private  String discription;
	private List<DiagnosticCenterBean> beans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<DiagnosticCenterBean> getBeans() {
		return beans;
	}
	public void setBeans(List<DiagnosticCenterBean> beans) {
		this.beans = beans;
	}
	@Override
	public String toString() {
		return "DiagnosticResponse [statusCode=" + statusCode + ", message=" + message + ", discription=" + discription
				+ ", beans=" + beans + "]";
	}
	
}

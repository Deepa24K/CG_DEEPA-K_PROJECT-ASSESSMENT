package com.capgemini.healthcaresystem.bean;

import java.util.List;

public class LoginResponse {
	private int statusCode;
	private String message;
	private  String discription;
	private List<LoginBean> beans;
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
	public List<LoginBean> getBeans() {
		return beans;
	}
	public void setBeans(List<LoginBean> beans) {
		this.beans = beans;
	}
	@Override
	public String toString() {
		return "LoginResponse [statusCode=" + statusCode + ", message=" + message + ", discription=" + discription
				+ ", beans=" + beans + "]";
	}
	
}

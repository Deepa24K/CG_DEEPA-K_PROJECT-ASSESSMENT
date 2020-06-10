package com.capgemini.healthcaresystem.bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserBean {
	@Id
	@Column(unique=true)
	@GeneratedValue
	private String userId;
	@Column(name="password")
	private String userPassword;
	@Column(name="name")
	private String userName;
	@Column
	private BigInteger contactNo;
	@Column(name="email")
	private String emailId;
	@Column(name="role")
	private String UserRole;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public BigInteger getContactNo() {
		return contactNo;
	}
	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", contactNo=" + contactNo + ", emailId=" + emailId + ", UserRole=" + UserRole + "]";
	}
	
	
}

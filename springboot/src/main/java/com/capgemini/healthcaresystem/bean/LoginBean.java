package com.capgemini.healthcaresystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoginBean {

		@Id
		@Column
		@GeneratedValue
		private int loginId;
		@Column(unique=true,nullable=false)
		private String email;
		@Column
		private String password;
		@Column
		private String role;
		public int getLoginId() {
			return loginId;
		}
		public void setLoginId(int loginId) {
			this.loginId = loginId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "LoginBean [loginId=" + loginId + ", email=" + email + ", password=" + password + ", role=" + role
					+ "]";
		}
		
	}

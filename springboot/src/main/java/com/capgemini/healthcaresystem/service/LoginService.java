package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.bean.LoginBean;

public interface LoginService {
	public LoginBean login(LoginBean loginBean);
	public boolean signup(LoginBean loginBean);
	public boolean updatePassword(LoginBean loginBean);
	public boolean deleteAccount(int id);
}

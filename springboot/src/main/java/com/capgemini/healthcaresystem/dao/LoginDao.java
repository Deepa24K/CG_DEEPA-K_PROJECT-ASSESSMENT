package com.capgemini.healthcaresystem.dao;

import com.capgemini.healthcaresystem.bean.LoginBean;

public interface LoginDao {
	public LoginBean login(LoginBean loginBean);
	public boolean signup(LoginBean loginBean);
	public boolean updatePassword(LoginBean loginBean);
	public boolean deleteAccount(int id);
}

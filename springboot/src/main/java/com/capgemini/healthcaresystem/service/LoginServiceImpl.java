package com.capgemini.healthcaresystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.bean.LoginBean;
import com.capgemini.healthcaresystem.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public LoginBean login(LoginBean loginBean) {
		return loginDao.login(loginBean);
	}

	@Override
	public boolean signup(LoginBean loginBean) {
		return loginDao.signup(loginBean);
	}

	@Override
	public boolean updatePassword(LoginBean loginBean) {
		return loginDao.updatePassword(loginBean);
	}

	@Override
	public boolean deleteAccount(int id) {
		return loginDao.deleteAccount(id);
	}

}

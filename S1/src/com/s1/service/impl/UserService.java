package com.s1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s1.dao.IUserDao;
import com.s1.entity.User;
import com.s1.service.IUserService;

/**
* @author 古学懂_Victor
*/
@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public int userLogup(User user) {
		return userDao.insertUser(user);
	}
	@Override
	public User userLogin(String name, String psd) {
		return userDao.getUserByPassword(name, psd);
	}
	@Override
	public String toString() {
		return this.userLogin("Hokdung", "123456").getName();
	}
}

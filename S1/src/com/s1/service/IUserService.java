package com.s1.service;

import com.s1.entity.User;

/**
* @author 古学懂_Victor
* @date 2020年5月22日
*/
public interface IUserService {
	User userLogin(String name, String psd);
	int userLogup(User user);
}

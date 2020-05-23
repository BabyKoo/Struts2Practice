package com.s1.dao;

import com.s1.entity.User;

/**
* @author 古学懂_Victor
* @date 2020年5月20日
*/
public interface IUserDao {
	/**
	 * 根据用户名和密码
	 * @return User
	 */
	User getUserByPassword(String name, String password);
	/**
	 * 插入用户
	 * @author 古学懂_Victor
	 * @param user
	 * @return
	 */
	int insertUser(User user);
}

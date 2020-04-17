package com.s1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1.entity.User;

public class UserDao {
	/**
	 * 根据用户密码
	 * 
	 * @return List
	 */
	public User getUserByPassword(String name, String password) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		User user = new User();

		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from user where name = ? and psd = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			System.out.println("gUbp: name: " + name);
			pStatement.setString(1, name);
			pStatement.setString(2, password);
			res = pStatement.executeQuery();
			// 把各属性封装到一个user对象中
			user = encapUser(res);
			if (user != null)
				System.out.println("resUn: " + user.getName());
			return user;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	// 把各属性封装到一个user对象中
	public User encapUser(ResultSet res) throws SQLException {
		User user = new User();
		if (res.next()) {
			int uId = res.getInt("user_id");
			System.out.println("uId: " + uId);
			int id = res.getInt("user_id");
			String uName = res.getString("name");
			String uPassword = res.getString("psd");
			String uEmail = res.getString("email");
			String birthDate = res.getString("birthDate");
			String gender = res.getString("gender");
			user.setId(id);
			user.setName(uName);
			user.setPsd(uPassword);
			user.setEmail(uEmail);
			user.setBirthDate(birthDate);
			user.setGender(gender);
			return user;
		} else {
			return null;
		}
	}
	
	public User insertUser(User user) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "insert into user (name, psd, email, birthDate, gender) values (?, ?, ?,  str_to_date(?, '%Y-%m-%d'), ?)";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getPsd());
			pStatement.setString(3, user.getEmail());
			pStatement.setString(4, user.getBirthDate());
			pStatement.setString(5, user.getGender());
			pStatement.executeUpdate();
			res = pStatement.getGeneratedKeys();
			int userId = 0;
			if (res.next()) {
				userId = res.getInt(1);
				user.setId(userId);
			}
			return user;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}
}

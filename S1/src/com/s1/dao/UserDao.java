package com.s1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;
//import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s1.common.HibernateSessionFactory;
import com.s1.entity.User;

public class UserDao {
	Session session = null;
	Transaction transaction = null;

	/**
	 * 根据用户名和密码
	 * 
	 * @return User
	 */
	public User getUserByPassword(String name, String password) {
		User user = new User();
		try {
			session = HibernateSessionFactory.getSession();
			Query<?> q=session.createQuery("select u from User u where name=:uname and psd=:upsd");
			q.setParameter("uname", name);
			q.setParameter("upsd", password);
			List<?> users=q.list();
			if(users.isEmpty()) return null;
			user = (User) users.get(0);
			System.out.println("ud "+user.getName());
			return user;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * 把各属性封装到一个user对象中
	 * 
	 * @param ResultSet res
	 * @return User
	 * @throws SQLException
	 */
	public User encapUser(ResultSet res) throws SQLException {
		User user = new User();
		if (res.next()) {
			int uId = res.getInt("user_id");
			System.out.println("uId: " + uId);
			int id = res.getInt("user_id");
			String uName = res.getString("name");
			String uPassword = res.getString("psd");
			String uEmail = res.getString("email");
			String birth_date = res.getString("birth_date");
			String gender = res.getString("gender");
			user.setId(id);
			user.setName(uName);
			user.setPsd(uPassword);
			user.setEmail(uEmail);
			user.setBirthDate(birth_date);
			user.setGender(gender);
			return user;
		} else {
			return null;
		}
	}

	public int insertUser(User user) {
//			String strSql = "insert into user (name, psd, email, birth_date, gender) values (?, ?, ?,  str_to_date(?, '%Y-%m-%d'), ?)";
		int num = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			num = Integer.parseInt(session.save(user).toString());
			transaction.commit();
		} catch (Exception e) {
			num = -1;
			e.printStackTrace();
		} finally {
			System.out.println("UDI " + num);
			HibernateSessionFactory.closeSession();
		}
		return num;
	}
}

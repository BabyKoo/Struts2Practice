package com.s1.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.s1.common.HibernateSessionFactory;
import com.s1.dao.IUserDao;
import com.s1.entity.User;

@Repository
public class UserDao implements IUserDao{
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserByPassword(String name, String password) {
		User user = new User();
		try {
			session = sessionFactory.openSession();
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
			sessionFactory.close();
		}
	}

	@Override
	public int insertUser(User user) {
//			String strSql = "insert into user (name, psd, email, birth_date, gender) values (?, ?, ?,  str_to_date(?, '%Y-%m-%d'), ?)";
		int num = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			num = Integer.parseInt(session.save(user).toString());
			transaction.commit();
		} catch (Exception e) {
			num = -1;
			e.printStackTrace();
		} finally {
			System.out.println("UDI " + num);
			sessionFactory.close();
		}
		return num;
	}
}

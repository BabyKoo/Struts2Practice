package com.s1.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.s1.common.HibernateSessionFactory;
import com.s1.dao.IStudentDao;
import com.s1.entity.Student;

@Repository
public class StudentDao implements IStudentDao {
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> getAllStudents() {
		try {
			session = sessionFactory.openSession();
			Query<Student> q = session.createQuery("select s from Student s");
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student stu = session.get(Student.class, student.getStuId());
			System.out.println("SDUD "+stu.getStuName());
//			stu = student;
			stu.setStuName(student.getStuName());
			stu.setStuNo(student.getStuNo());
			stu.setStuGender(student.getStuGender());
			stu.setStuClass(student.getStuClass());
			stu.setDpart(student.getDpart());
			stu.setAdmissionDate(student.getAdmissionDate());
			stu.setGpa(student.getGpa());
			session.update(stu);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public int insertStudent(Student student) {
		int num = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			num = Integer.parseInt(session.save(student).toString());
			transaction.commit();
		} catch (Exception e) {
			num = -1;
			e.printStackTrace();
		} finally {
			System.out.println("SDID " + num);
			sessionFactory.close();
		}
		return num;
	}

	@Override
	public boolean deleteStudentById(int id) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student stu=session.get(Student.class, id);
			session.delete(stu);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public List<Student> getStudentsBy(String name, String value) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Query<Student> q = session.createQuery("select s from Student s where "+name+"=:value");
			q.setParameter("value", value);
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}
	public Student getStudentById(int id) {
		try {
			session = sessionFactory.openSession();
			Query<Student> q = session.createQuery("select s from Student s where stuId=:sId");
			q.setParameter("sId", id);
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students.get(0);
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}
}

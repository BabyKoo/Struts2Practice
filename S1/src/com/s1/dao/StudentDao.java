package com.s1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.s1.common.HibernateSessionFactory;
import com.s1.entity.Student;

public class StudentDao {
	Session session = null;
	Transaction transaction = null;

	/*
	 * 返回所有学生
	 * 
	 * @return List
	 */
	public List<Student> getAllStudents() {
		try {
			session = HibernateSessionFactory.getSession();
			Query<Student> q = session.createQuery("select s from Student s");
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 根据姓名查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByName(String name) {
		try {
			session = HibernateSessionFactory.getSession();
			Query<Student> q = session.createQuery("select s from Student s where stuName=:sName");
			q.setParameter("sName", name);
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 根据ID查询学生
	 * 
	 * @return Student
	 */
	public Student getStudentById(int id) {
		try {
			session = HibernateSessionFactory.getSession();
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
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 根据学号查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByNo(String No) {
		try {
			session = HibernateSessionFactory.getSession();
			Query<Student> q = session.createQuery("select s from Student s where stuNo=:sNo");
			q.setParameter("sNo", No);
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 根据院系查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByDpart(String dpart) {
		try {
			session = HibernateSessionFactory.getSession();
			Query<Student> q = session.createQuery("select s from Student s where dpart=:dpart");
			q.setParameter("dpart", dpart);
			List<Student> students = q.list();
			if (students.isEmpty())
				return null;
			return students;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 
	 */
	ArrayList<Student> encapStudents(ResultSet res) throws SQLException {
		ArrayList<Student> list = new ArrayList<Student>();
		while (res.next()) {
			Student student = new Student();
			student.setStuId(res.getInt("stu_id"));
			student.setStuName(res.getString("stu_name"));
			student.setStuNo(res.getString("stu_no"));
			student.setStuGender(res.getString("stu_gender"));
			student.setDpart(res.getString("dpart"));
			student.setStuClass(res.getString("class"));
			student.setAdmissionDate(res.getString("admission_date"));
			student.setGpa(res.getFloat("gpa"));
			System.out.println("Encap " + res.getString("stu_name"));
			list.add(student);
		}
		return list;
	}

	/*
	 * 更新学生数据
	 * 
	 * @return boolean
	 */
	public boolean updateStudent(Student student) {
		try {
			session = HibernateSessionFactory.getSession();
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
			HibernateSessionFactory.closeSession();
		}
	}

	/*
	 * 插入学生数据
	 * 
	 * @return int
	 */
	public int insertStudent(Student student) {
		int num = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			num = Integer.parseInt(session.save(student).toString());
			transaction.commit();
		} catch (Exception e) {
			num = -1;
			e.printStackTrace();
		} finally {
			System.out.println("SDID " + num);
			HibernateSessionFactory.closeSession();
		}
		return num;
	}

	/*
	 * 根据ID删除学生
	 * 
	 * @return Student
	 */
	public boolean deleteStudentById(int id) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Student stu=session.get(Student.class, id);
			session.delete(stu);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}

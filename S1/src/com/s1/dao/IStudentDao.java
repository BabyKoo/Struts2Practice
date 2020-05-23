package com.s1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s1.entity.Student;

/**
 * @author 古学懂_Victor
 */
public interface IStudentDao {
	Session session = null;
	Transaction transaction = null;
	/*
	 * 返回所有学生
	 * @return List
	 */
	public List<Student> getAllStudents();
	/*
	 * 根据条件查询学生
	 * 	 * @return List
	 */
	public List<Student> getStudentsBy(String name, String value);
	/*
	 * 更新学生数据
	 * @return boolean
	 */
	public boolean updateStudent(Student student);
	/*
	 * 插入学生数据
	 * @return int
	 */
	public int insertStudent(Student student);
	/*
	 * 根据ID删除学生
	 * @return Student
	 */
	public boolean deleteStudentById(int id);
}

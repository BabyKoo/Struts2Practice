package com.s1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.s1.entity.Student;

public class StudentDao {
	/*
	 * 返回所有学生
	 * 
	 * @return List
	 */
	public List<Student> getAllStudents() {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from student";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			res = pStatement.executeQuery();
			return encapStudents(res);
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 根据姓名查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByName(String name) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from student where stu_name = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1, name);
			res = pStatement.executeQuery();
			return encapStudents(res);
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 根据ID查询学生
	 * 
	 * @return Student
	 */
	public Student getStudentById(int id) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from student where stu_id = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setInt(1, id);
			res = pStatement.executeQuery();
			return encapStudents(res).get(0);
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 根据学号查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByNo(String No) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from student where stu_no = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1, No);
			res = pStatement.executeQuery();
			return encapStudents(res);
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 根据院系查询学生
	 * 
	 * @return List
	 */
	public List<Student> getStudentsByDpart(String dpart) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from student where dpart = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1, dpart);
			res = pStatement.executeQuery();
			return encapStudents(res);
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
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
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
//		Student student=this.getStudentsById(id);
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "update student set stu_name=?, stu_no=?, stu_gender=?, dpart=?, class=?, admission_date=?, gpa=? where stu_id = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1, student.getStuName());
			pStatement.setString(2, student.getStuNo());
			pStatement.setString(3, student.getStuGender());
			pStatement.setString(4, student.getDpart());
			pStatement.setString(5, student.getStuClass());
			if (!student.getAdmissionDate().isBlank())
				pStatement.setString(6, student.getAdmissionDate());
			else
				pStatement.setString(6, null);
			pStatement.setFloat(7, student.getGpa());
			pStatement.setInt(8, student.getStuId());
			pStatement.executeUpdate();
			return true;
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return false;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 插入学生数据
	 * 
	 * @return int
	 */
	public int insertStudent(Student student) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		int i = -1;
//		Student student=this.getStudentsById(id);
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "insert into student (stu_name, stu_no, stu_gender, dpart, class, admission_date, gpa)values(?, ?, ?, ?, ?, ?, ?)";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, student.getStuName());
			pStatement.setString(2, student.getStuNo());
			pStatement.setString(3, student.getStuGender());
			pStatement.setString(4, student.getDpart());
			pStatement.setString(5, student.getStuClass());
			if (!student.getAdmissionDate().isBlank())
				pStatement.setString(6, student.getAdmissionDate());
			else
				pStatement.setString(6, null);
			pStatement.setFloat(7, student.getGpa());
			pStatement.executeUpdate();
			res = pStatement.getGeneratedKeys();
			if (res != null) {
				res.next();
				i = res.getInt(1);
				System.out.println(res.getInt(1));
			}
			System.out.println("Inserted " + i);
			return i;
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return -1;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}

	/*
	 * 根据ID删除学生
	 * 
	 * @return Student
	 */
	public boolean deleteStudentById(int id) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		int i = -1;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "delete from student where stu_id = ?";
			System.out.println(strSql);
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setInt(1, id);
			i = pStatement.executeUpdate();
			System.out.println(i);
			if (i > 0)
				return true;
			else
				return false;
		} catch (SQLException sqlX) {
			sqlX.printStackTrace();
			return false;
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}
}

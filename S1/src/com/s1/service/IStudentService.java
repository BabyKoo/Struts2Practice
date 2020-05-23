package com.s1.service;

import java.util.List;

import com.s1.entity.Student;

/**
* @author 古学懂_Victor
*/
public interface IStudentService {
	List<Student> listStudents();
	boolean updateStudent(Student student);
	int insertStudent(Student student);
	boolean deleteStudent(int id);
	List<Student> getStudentsBy(String name, String value);
	Student getStudentById(int id);
}

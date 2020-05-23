package com.s1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s1.dao.impl.StudentDao;
import com.s1.entity.Student;
import com.s1.service.IStudentService;

/**
* @author 古学懂_Victor
*/
@Service
public class StudentService implements IStudentService {
	@Autowired
	StudentDao sd=new StudentDao();
	
	@Override
	public List<Student> listStudents() {
		return sd.getAllStudents();
	}

	@Override
	public boolean updateStudent(Student student) {
		return sd.updateStudent(student);
	}

	@Override
	public int insertStudent(Student student) {
		return sd.insertStudent(student);
	}

	@Override
	public boolean deleteStudent(int id) {
		return sd.deleteStudentById(id);
	}

	@Override
	public List<Student> getStudentsBy(String name, String value) {
		return sd.getStudentsBy(name, value);
	}

	@Override
	public Student getStudentById(int id) {
		return sd.getStudentById(id);
	}
	
}

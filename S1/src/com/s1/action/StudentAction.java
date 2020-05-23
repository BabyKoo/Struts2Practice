package com.s1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.s1.dao.impl.StudentDao;
import com.s1.entity.Student;
import com.s1.service.impl.StudentService;
import com.s1.service.impl.UserService;

public class StudentAction {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();
	Student student=new Student();
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	StudentService studentService = (StudentService) ctx.getBean("studentService");
	List<Student> list = new ArrayList<Student>();
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String all(){
		System.out.println("QS");
		list=studentService.listStudents();
		if(list!=null) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byName(){
		System.out.println("QS");
		list=studentService.getStudentsBy("stuName", student.getStuName());
		if(list!=null) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byDpart(){
		System.out.println("QS");
		list=studentService.getStudentsBy("dpart", student.getDpart());
		if(list!=null) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byNo(){
		System.out.println("QS");
		list=studentService.getStudentsBy("stuNo", student.getStuNo());
		if(list!=null) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String insert(){
		System.out.println("QS");
		int i=studentService.insertStudent(student);
		if(i!=-1) {
			student.setStuId(i);
			list.add(student);
			session.put("Result", list);
			System.out.println("Inserted "+list.get(0).getStuName());
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String update(){
		System.out.println("QS");
		System.out.println(student.getStuId());
		if(studentService.updateStudent(student)) {
			list.add(student);
			session.put("Result", list);
			System.out.println("Updated "+list.get(0).getStuId());
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String delete(){
		System.out.println("QS");
		boolean consq=studentService.deleteStudentById(student.getStuId());
		if(consq) {
			System.out.println("Deleted "+student.getStuId());
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
}

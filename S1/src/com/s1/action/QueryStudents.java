package com.s1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.s1.dao.StudentDao;
import com.s1.entity.Student;

public class QueryStudents {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();
	Student student=new Student();
	StudentDao sd=new StudentDao();
	List<Student> list = new ArrayList<Student>();
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String all(){
		System.out.println("QS");
		list=sd.getAllStudents();
		if(list!=null&&list.size()>0) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byName(){
		System.out.println("QS");
		list=sd.getStudentsByName(student.getStuName());
		if(list!=null&&list.size()>0) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byDpart(){
		System.out.println("QS");
		list=sd.getStudentsByDpart(student.getDpart());
		if(list!=null&&list.size()>0) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String byNo(){
		System.out.println("QS");
		list=sd.getStudentsByNo(student.getStuNo());
		if(list!=null&&list.size()>0) {
			session.put("Result", list);
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
	public String insert(){
		System.out.println("QS");
		int i=sd.insertStudent(student);
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
		if(sd.updateStudent(student)) {
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
		boolean consq=sd.deleteStudentById(student.getStuId());
		if(consq) {
			System.out.println("Deleted "+student.getStuId());
			return "querySuccess";
		}else {
			session.put("errorMsg", "Query fail. ");
			return "queryFail";
		}
	}
}

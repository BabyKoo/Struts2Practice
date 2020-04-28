package com.s1.entity;

public class Student {
	int stuId;
	String stuNo;
	String stuName;
	String stuGender;
	String dpart;
	String stuClass;
	String admissionDate;
	float gpa=(float)0.0;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuGender() {
		return stuGender;
	}
	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}
	public String getDpart() {
		return dpart;
	}
	public void setDpart(String dpart) {
		this.dpart = dpart;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getAdmissionDate() {
//		if(this.admissionDate.isBlank()) return null;
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(Float gpa) {
		if(gpa==null) this.gpa=(float)0;
		else this.gpa = gpa;
	}
}

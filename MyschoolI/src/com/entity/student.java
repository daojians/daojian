package com.entity;

public class student {
	private int studentno;
	private String studentname;
	
	
	public student() {
		super();
	}
	public student(int studentno, String studentname) {
		super();
		this.studentno = studentno;
		this.studentname = studentname;
	}
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
}

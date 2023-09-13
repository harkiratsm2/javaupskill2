package com.hcl.entity;

public class Student {

	private int rollNo;
	private String studentName;
	private String address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNo, String studentName, String address) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

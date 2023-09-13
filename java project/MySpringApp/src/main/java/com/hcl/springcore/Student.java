package com.hcl.springcore;

public class Student {

	private int rollNo;
	private String studentName;
	private String address;

	public Student() {
		super();
	}

	public Student(int rollNo, String studentName, String address) {
		super();
		System.out.println("Constructor called");
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		System.out.println("rollNo Setter called");
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		System.out.println("studentName Setter called");
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("address Setter called");
		this.address = address;
	}

}

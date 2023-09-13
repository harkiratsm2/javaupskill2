package comparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student1 implements Comparable<Student1>
{
	private String name;
	private int age;
	private double grade;
	
	public Student1() {
		super();

	}
	public Student1(String name, int age, double grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Student1 stu)
	{
		return this.age - stu.age;
	}
	
}

class NameCompare1 implements Comparator<Student1>
{
	public int compare(Student1 s1, Student1 s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

class GradeCompare1 implements Comparator<Student1>
{
	public int compare(Student1 s1, Student1 s2)
	{
		if(s1.getGrade() > s2.getGrade())
			return 1;
		if(s1.getGrade() < s2.getGrade())
			return -1;
		else
			return 0;
	}
}

public class ComparablePractice {

	public static void main(String[] args) {
		
		List<Student1> students = new ArrayList<Student1>();
		
		Student1 student1 = new Student1("Harkirat Singh", 23, 84.22);
		Student1 student2 = new Student1("Armaan Sidhu", 20, 93.73);
		Student1 student3 = new Student1("Suhail Ali", 27, 77.30);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		Collections.sort(students);
		
		System.err.println("Students Sorted By Age : ");
		
		for(Student1 stu : students)
		{
			System.out.println(stu.getName() + "  " + stu.getAge() + "  " + stu.getGrade());
		}
		
		NameCompare1 nameCompare = new NameCompare1();
		Collections.sort(students, nameCompare);
		
		System.err.println("Students Sorted By Name : ");
		
		for(Student1 stu : students)
		{
			System.out.println(stu.getName() + "  " + stu.getAge() + "  " + stu.getGrade());
		}

		GradeCompare1 gradeCompare = new GradeCompare1();
		
		Collections.sort(students, gradeCompare);
		
		System.err.println("Students Sorted By Grades : ");
		
		for(Student1 stu : students)
		{
			System.out.println(stu.getName() + "  " + stu.getAge() + "  " + stu.getGrade());
		}
		
	}

}

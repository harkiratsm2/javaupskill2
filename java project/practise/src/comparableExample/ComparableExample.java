package comparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
	private String name;
	private int age;
	private double grade;

	public Student() {
		super();
	}

	public Student(String name, int age, double grade) {
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
	public int compareTo(Student stu) {

		return stu.age - this.age;
	}

}

class NameCompare implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

class GradeCompare implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		if(s1.getGrade() > s2.getGrade())
			return 1;
		if(s1.getGrade() < s2.getGrade())
			return -1;
		else
			return 0;
	}
}

public class ComparableExample {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();
		
		Student student1 = new Student("Harkirat Singh", 23, 90.22);
		Student student2 = new Student("Suhail Ali", 21, 92.43);
		Student student3 = new Student("Sufyaan Khan", 25, 84.7);
		Student student4 = new Student("Kamalpreet Singh", 20, 87.50);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		
		Collections.sort(students);
		
		System.err.println("Students sorted by age in Descending Order : ");
		
		for(Student stu : students)
		{
			System.out.println(stu.getName()+"  "+stu.getAge()+"  "+stu.getGrade());
		}
		
		NameCompare nameCompare = new NameCompare();
		
		Collections.sort(students, nameCompare);
		
		System.err.println("Students sorted by Name : ");
		
		for(Student stu : students)
		{
			System.out.println(stu.getName()+"  "+stu.getAge()+"  "+stu.getGrade());
		}
		
		GradeCompare gradeCompare = new GradeCompare();
		
		Collections.sort(students, gradeCompare);
		
		System.err.println("Students sorted by Grade : ");
		
		for(Student stu : students)
		{
			System.out.println(stu.getName()+"  "+stu.getAge()+"  "+stu.getGrade());
		}

	}

}

package practise;

import java.util.Scanner;

public class GradesUsingSwitch {

	public static void main (String []args)
	{
		char grade;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Grade : ");
		grade = sc.next().charAt(0);
		
		switch(grade)
		{
			case 'A':
			case 'a':
				System.out.println("Excellent Job!");
				break;
				
			case 'B':
			case 'b':
				System.out.println("Good Job!");
				break;
				
			case 'C':
			case 'c':
				System.out.println("Average Job!");
				
				
			case 'D':
			case 'd':
				System.out.println("Needs Improvement");
				break;
				
			case 'F':
			case 'f':
				System.out.println("Failed");
				break;
				
			default:
				System.out.println("Invalid Grade");
				
		}
		
		sc.close();
		
	}
}

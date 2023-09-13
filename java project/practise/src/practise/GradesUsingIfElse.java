package practise;

import java.util.Scanner;

public class GradesUsingIfElse {
	
	public static void main (String []args)
	{
		char grade;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Grade : ");
		grade = sc.next().charAt(0);
		
		if(grade == 'A' || grade == 'a')
			System.out.println("Excellent Job!");
		
		else if(grade == 'B' || grade == 'b')
			System.out.println("Good Job!");
		
		else if(grade == 'C' || grade == 'c')
			System.out.println("Average Job!");
		
		else if(grade == 'D' || grade == 'd')
			System.out.println("Needs Improvement");
		
		else if(grade == 'F' || grade == 'f')
			System.out.println("Failed");
		
		else
			System.out.println("Invalid Grade");
		
		sc.close();
	}

}

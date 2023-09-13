package practise;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String []args)
	{
		int num, total = 1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number whose Factorial you want : ");
		num = sc.nextInt();
		
		int temp = num;
		while(temp > 0)
		{
			total *= temp;
			--temp;
		}
		
		System.out.println("Factorial of " + num + " is " + total);
		
		sc.close();
	}

}

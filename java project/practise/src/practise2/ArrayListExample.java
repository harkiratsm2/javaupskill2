package practise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
	
	public static void main (String []args)
	{
		Scanner sc = new Scanner(System.in);
		
		int total, sum = 0;
		
		List<Integer> myIntegers = new ArrayList<Integer>();
		
		System.out.println("Enter the No. of Elements : ");
		total = sc.nextInt();
		
		System.out.println("Enter the Elements : ");
		for(int i = 0; i < total; i++)
		{
			int element = sc.nextInt();
			myIntegers.add(element);
		}
		
		System.out.println("List Elements are : ");
		for(int myInteger : myIntegers)
		{
			System.out.println(myInteger);
		}
		
		for(int myInteger : myIntegers)
		{
			sum += myInteger;
		}
		System.out.println("Sum of List Elements is : "+sum);
		
		sc.close();
	}

}

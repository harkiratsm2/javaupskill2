package practise2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class LinkedListExample {
	
	public static void main(String []args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int total;
		
		List<String> elements = new LinkedList<String>();
		
		System.out.println("Enter the No. of Elements : ");
		total = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the Elements : ");
		for(int i = 0; i < total; i++)
		{
			String element = sc.nextLine();
			elements.add(element);
		}
		
		System.out.println("List Elements in Reverse Order are : ");
		
//		Collections.reverse(elements);
		
		for(int i = elements.size() - 1; i >= 0; i-- )
		{
			System.out.println(elements.get(i));
		}
		
//		for(String element : elements)
//		{
//			System.out.println(element);
//		}
		
		sc.close();
	}

}

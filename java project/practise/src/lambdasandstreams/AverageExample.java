package lambdasandstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		System.out.println("Enter no. of elements : ");
		int total = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Numbers : ");
		
		for(int i = 0; i < total; i++)
		{
			int num = sc.nextInt();
			numbers.add(num);
		}
		
		System.out.println("Average of Numbers : "+numbers.stream().mapToInt(num -> num).average());
		
		sc.close();

	}

}

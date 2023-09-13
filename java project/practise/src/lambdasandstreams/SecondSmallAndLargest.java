package lambdasandstreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SecondSmallAndLargest {
	
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

		System.out.println("Second Smallest : "+numbers.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get());
		System.out.println("Largest : "+numbers.stream().sorted(Comparator.reverseOrder()).findFirst().get());
		
		sc.close();

	}

}

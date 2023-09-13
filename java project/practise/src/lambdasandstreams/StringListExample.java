package lambdasandstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringListExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> strings = new ArrayList<String>();
		
		System.out.println("Enter no. of strings : ");
		int total = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Strings : ");
		
		for(int i = 0; i < total; i++)
		{
			String num = sc.nextLine();
			strings.add(num);
		}
		
		System.out.println("UpperCase Strings : ");
		strings.stream().map(element -> element.toUpperCase()).forEach(element -> System.out.println(element));
		
		System.out.println("LowerCase Strings : ");
		strings.stream().map(element -> element.toLowerCase()).forEach(element -> System.out.println(element));
		
		sc.close();

	}

}

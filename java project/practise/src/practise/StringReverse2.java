package practise;

import java.util.Scanner;

public class StringReverse2 {
	
	public static void main (String []args)
	{
		
		String originalString;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		originalString = sc.nextLine();
		
		System.out.println("Original String = "+originalString);
		
		StringBuffer sb = new StringBuffer(originalString);
		
		System.out.println("Reversed String : "+sb.reverse());
		
		sc.close();
	}

}

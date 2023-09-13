package practise;

import java.util.Scanner;

public class StringReverse {
	
	public static void main (String []args)
	{
		String originalString, reversedString = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		originalString = sc.nextLine();
		
		System.out.println("Original String : "+originalString);
		
		for(int i = originalString.length() - 1; i >= 0; i--)
		{
			char ch = originalString.charAt(i);
			reversedString = reversedString + ch;
		}
		
		System.out.println("Reversed String : "+reversedString);
		
		sc.close();
	}

}

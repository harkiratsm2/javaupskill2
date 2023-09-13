package practise;

import java.util.Scanner;

public class StringSpace {

	public static void main(String[] args) {
		
		String originalStr, processedStr = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		
		originalStr = sc.nextLine();
		
		System.out.println("Original String : "+originalStr);
		
		for(int i = 0; i < originalStr.length(); i++)
		{
			if(originalStr.charAt(i) != ' ')
				processedStr = processedStr + originalStr.charAt(i);
			else
				continue;
		}

		System.out.println("String after Removing Spaces : "+processedStr);
		
		sc.close();
	}

}

package practise;

import java.util.Scanner;

public class StringRepeated {

	public static void main(String[] args) {
		
		String str;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		
		str = sc.nextLine();
		
		for(int i = 0; i < str.length(); i++)
		{
			for(int j = i + 1; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					System.out.println(str.charAt(i)+" is first repeated character in string");
					i = str.length();
					break;
				}
			}
		}
		
		sc.close();

	}

}

package practise;

import java.util.Scanner;

public class StringNonRepeated {

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
					break;
				}
				if(j == str.length() - 1)
				{
					System.out.println(str.charAt(i)+" is the first non-repeated character");
					i = str.length() - 1;
					break;
				}
			}
		}
			
		sc.close();

	}

}

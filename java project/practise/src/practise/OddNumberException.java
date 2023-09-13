package practise;

import java.util.Scanner;

class MyException extends Exception
{
	public MyException(String message)
	{
		System.out.println(message);
	}
}


public class OddNumberException {
	
	public static void main(String []args)
	{
		int num;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter an Even Number : ");
		num = sc.nextInt();
		
		try
		{
			if(num % 2 != 0)
				throw new MyException("Odd Number Exception");
			else
				System.out.println("Number is Even");
		}
		catch(MyException e)
		{
			System.out.println(e);
		}
		sc.close();
	}

}

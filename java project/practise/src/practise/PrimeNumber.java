package practise;

import java.util.Scanner;

public class PrimeNumber extends Thread {
	
	public void run()
	{
	
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("Enter Limit : ");
		int limit = sc.nextInt();
		
		for( int i = 2; i <= limit ; i++)
		{
			int count = 0;
			for( int j = 2; j <= i/2; j++)
			{
				if( i % j == 0)
				{
					count++;
					break;
				}
			}
			if( count == 0 )
			{
				System.out.println(i);
				sum += i;
			}
		}
		
		System.out.println("Sum of Prime Numbers from 2 to "+limit+" is "+sum);
		
		sc.close();
	}
	public static void main (String []args)
	{
		
		PrimeNumber pm = new PrimeNumber();
		pm.start();
	}

}

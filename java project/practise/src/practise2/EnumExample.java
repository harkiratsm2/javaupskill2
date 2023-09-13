package practise2;

import java.util.Scanner;

public class EnumExample {
	
	enum MONTHS
	{
		JANUARY,
		FEBRUARY,
		MARCH,
		APRIL,
		MAY,
		JUNE,
		JULY,
		AUGUST,
		SEPTEMBER,
		OCTOBER,
		NOVEMBER,
		DECEMBER
	}
	
	public static void main (String []args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Month : ");
		
		String month = sc.next();
		
		MONTHS value = MONTHS.valueOf(month.toUpperCase());
		
		getDays(value);
		
		sc.close();
		
	}
	
	public static void getDays(MONTHS month)
	{
		switch(month)
		{
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			 System.out.println("31");
			break;
			
		case FEBRUARY:
			System.out.println("28");
			break;
			
		case APRIL:
		case JUNE:
		case SEPTEMBER:
		case NOVEMBER:
			System.out.println("30");
			break;
			
		default:
			System.out.println("Invalid");;
		}
	}

}

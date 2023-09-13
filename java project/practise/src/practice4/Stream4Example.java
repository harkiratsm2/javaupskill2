package practice4;

import java.util.ArrayList;
import java.util.List;

public class Stream4Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		
		int firstNumber = numbers.stream().mapToInt(Integer::intValue).findFirst().getAsInt();
		
		System.out.println(firstNumber);
		
//		boolean check = numbers.contains(5);
//		
//		System.out.println(check);
//		
//		int lastNumber = numbers.get(numbers.size() - 1);
//		
//		System.out.println(lastNumber);
		
		int size = numbers.size();
		
		int n = numbers.stream().skip(size - 1).mapToInt(Integer::intValue).findFirst().getAsInt();
		
		System.out.println(n);
		
		int checkNum = numbers.stream().filter(num -> num == '5').mapToInt(Integer::intValue).findFirst().orElse(0);
		
		System.out.println(checkNum);
		
		long evenNumbersCount = numbers.stream().filter(num -> num % 2 == 0).count();
		
		System.out.println(evenNumbersCount);
		
		

	}

}

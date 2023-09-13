package practice3;

import java.util.ArrayList;
import java.util.List;

public class Stream7Example {

	public static void main(String[] args) {
	
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		
		int maxValue = numbers.stream().distinct().mapToInt(Integer::intValue).max().getAsInt();
		
		System.out.println(maxValue);
		
		int minValue = numbers.stream().distinct().mapToInt(Integer::intValue).min().getAsInt();
		
		System.out.println(minValue);

	}

}

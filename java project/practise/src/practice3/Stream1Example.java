package practice3;

import java.util.ArrayList;
import java.util.List;

public class Stream1Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		
		double average = numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
		
		System.out.println(average);

	}

}

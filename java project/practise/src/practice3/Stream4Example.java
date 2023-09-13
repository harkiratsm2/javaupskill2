package practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		
		System.out.println(distinctNumbers);

	}

}

package practice4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream6Example {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		
		System.out.println(numbers.stream().mapToInt(Integer::intValue).max().getAsInt());
		
		numbers.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		numbers.stream().map(num -> num*num*num).forEach(System.out::println);
		
	}

}

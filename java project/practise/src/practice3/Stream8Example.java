package practice3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream8Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		numbers.add(2);
		
		int secondSmallest = numbers.stream().distinct().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
		
		int secondLargest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println(secondSmallest+"  "+secondLargest);

	}

}

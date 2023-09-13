package practice4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stream3Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		
		numbers.stream().filter(num -> Collections.frequency(numbers, num) >1)
        .collect(Collectors.toSet()).forEach(System.out::println);

	}

}

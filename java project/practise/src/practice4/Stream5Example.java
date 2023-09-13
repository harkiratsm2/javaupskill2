package practice4;

import java.util.ArrayList;
import java.util.List;

public class Stream5Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		numbers.add(78);
		numbers.add(34);
		
		long total = numbers.stream().count();
		
		System.out.println(total);

	}

}

package practice3;

import java.util.ArrayList;
import java.util.List;

public class Stream3Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(3);
		numbers.add(2);
		numbers.add(78);
		numbers.add(34);
		numbers.add(29);
		
		int sumOfEvens = numbers.stream().filter(num -> num%2 == 0).mapToInt(Integer::intValue).sum();
		
		int sumOfOdds = numbers.stream().filter(num -> num %2 !=0).mapToInt(Integer::intValue).sum();
		
		System.out.println(sumOfEvens+"  "+sumOfOdds);

	}

}

package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMinMax {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		
//		List<Integer> nums = Arrays.asList(2,3,4);
//		
//		nums.add(7);
		
		numbers.add(10);
		numbers.add(19);
		numbers.add(7);
		numbers.add(54);
		numbers.add(2);
		numbers.add(37);
		
		int maxValue = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
		
		int minValue = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
		
		System.out.println("Max Value: "+maxValue);
		System.out.println("Min Value: "+minValue);

	}

}

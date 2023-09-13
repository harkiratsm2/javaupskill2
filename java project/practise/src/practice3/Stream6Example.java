package practice3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream6Example {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		
		names.add("Harkirat Singh");
		names.add("Suhail Ali");
		names.add("Ankit Sharma");
		
		names.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	}

}

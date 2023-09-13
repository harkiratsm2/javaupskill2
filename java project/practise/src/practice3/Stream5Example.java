package practice3;

import java.util.ArrayList;
import java.util.List;

public class Stream5Example {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		
		names.add("Harkirat Singh");
		names.add("Suhail Ali");
		names.add("Ankit Sharma");
		
		System.out.println(names.stream().filter(name -> name.startsWith("A")).count());
		

	}

}

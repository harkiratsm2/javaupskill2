package practice3;

import java.util.ArrayList;
import java.util.List;

public class Stream2Example {
	
	public static void main(String []args)
	{
		List<String> names = new ArrayList<>();
		
		names.add("Harkirat Singh");
		names.add("Suhail Ali");
		names.add("Ankit Sharma");
		
		names.stream().map(name -> name.toLowerCase()).forEach(System.out::println);
		
		names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
	}

}

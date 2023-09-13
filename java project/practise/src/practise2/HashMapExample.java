package practise2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample {

	public static void main(String[] args) {
	
		
		Map<String, Integer> studentMarks = new HashMap<String, Integer>();
		
		studentMarks.put("Harkirat Singh", 90);
		studentMarks.put("Suhail", 70);
		studentMarks.put("Sufyaan", 80);
		
		System.out.println("Students are : ");
		for(Map.Entry<String, Integer> map: studentMarks.entrySet())
		{
			System.out.println(map.getKey() + ": " + map.getValue());
		}
		
		System.out.println();
		
		 Entry<String, Integer> leastValue = studentMarks
	                .entrySet()
	                .stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
	                .findFirst()
	                .get();
		 
		 studentMarks
	        .entrySet()
	        .removeIf(entry -> entry.getValue().equals(leastValue.getValue()));
		 
		 System.out.println("Students after removing least Grades are : ");
			for(Map.Entry<String, Integer> map: studentMarks.entrySet())
			{
				System.out.println(map.getKey() + ": " + map.getValue());
			}
	}

}

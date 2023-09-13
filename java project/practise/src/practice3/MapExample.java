package practice3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		
		Map<Integer,String> students = new HashMap<Integer,String>();
		
		students.put(101, "Harkirat Singh");
		students.put(102, "Ankit Sharma");
		students.put(103, "Sufyaan Khan");
		
		for(Map.Entry<Integer, String> student : students.entrySet())
		{
			System.out.println(student.getKey()+"  "+student.getValue());
		}
		
		students.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

	}

}

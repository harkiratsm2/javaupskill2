package practice3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<String>();
		
		fruits.add("Apples");
		fruits.add("Grapes");
		fruits.add("Mango");
		fruits.add("Banana");
		
		System.out.println(fruits);
		
		Iterator<String> itr = fruits.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		itr.remove();
		
		System.out.println(fruits);
		
		fruits.set(1, "PineApple");
		Collections.sort(fruits);
		
		for(String fruit : fruits)
		{
			System.out.println(fruit);
		}
		
		System.out.println(fruits.indexOf("Mango"));
	}

}

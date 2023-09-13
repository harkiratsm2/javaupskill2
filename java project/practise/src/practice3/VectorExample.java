package practice3;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		
		Vector<String> students = new Vector<String>();
		
		students.add("Harkirat Singh");
		students.add("Ankit Kumar");
		students.add("Suhail Ali");
		
		Enumeration<String> en = students.elements();
		
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}

		Iterator<String> itr = students.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}

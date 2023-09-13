package practice3;

import java.util.function.Predicate;

public class FuncPredicate {

	public static void main(String[] args) {
		
		Predicate<Integer> predicate = (num) -> num > 5;
		
		System.out.println(predicate.test(4));

	}

}

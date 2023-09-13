package practice3;

import java.util.function.Function;

public class FuncFunction {

	public static void main(String[] args) {
		
		Function<Integer, Integer> function = (num) ->  num*5;
		
		System.out.println(function.apply(4));

	}

}

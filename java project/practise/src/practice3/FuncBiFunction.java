package practice3;

import java.util.function.BiFunction;

public class FuncBiFunction {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> biFunction = (num1, num2) -> num1*num2;
		
		System.out.println(biFunction.apply(9, 5));

	}

}

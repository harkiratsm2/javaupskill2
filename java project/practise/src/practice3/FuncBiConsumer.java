package practice3;

import java.util.function.BiConsumer;

public class FuncBiConsumer {

	public static void main(String[] args) {
		
		BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name+"  "+age);
		
		biConsumer.accept("Harkirat Singh", 23);

	}

}

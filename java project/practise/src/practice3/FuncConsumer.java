package practice3;

import java.util.function.Consumer;

public class FuncConsumer {

	public static void main(String[] args) {

		Consumer<String> consumer = (message) -> System.out.println(message);
		
		consumer.accept("My name is Harkirat Singh");
	}

}

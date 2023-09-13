package practice3;

import java.util.function.Supplier;

public class FuncSupplier {

	public static void main(String[] args) {
		
		Supplier<String> supplier = () -> {return "Message from Supplier";};
		
		System.out.println(supplier.get());

	}

}

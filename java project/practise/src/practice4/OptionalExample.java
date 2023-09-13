package practice4;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		
		String[] strings = new String[10];
		
		Optional<String> checkStr = Optional.ofNullable(strings[5]);
		
		if(checkStr.isPresent())
		{
			String str = strings[5].toLowerCase();
			System.out.println(str);
		}
		else
			System.out.println("String is null");

	}

}

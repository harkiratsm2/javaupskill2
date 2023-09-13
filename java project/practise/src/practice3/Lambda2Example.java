package practice3;

interface Name
{
	public String getName(String name);
}

public class Lambda2Example {

	public static void main(String[] args) {
		
		Name nm = (name) -> {
			return name;
		};
		
		System.out.println(nm.getName("Harkirat Singh"));

	}

}

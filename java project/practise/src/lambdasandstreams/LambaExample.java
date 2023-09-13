package lambdasandstreams;

interface addNumbers
{
	int add(int a, int b);
}

public class LambaExample {

	public static void main(String[] args) {

		addNumbers addObj = (a, b) -> a + b;
		
		int result = addObj.add(10, 15);
		
		System.out.println(result);

	}

}

package practice3;

interface Add
{
	public int getSum(int a, int b);
}

public class Lambda3Example {

	public static void main(String[] args) {
		
		Add add = (a,b) -> a+b;
		
		System.out.println(add.getSum(3, 8));
		
		Add add1 = new Add(){
			public int getSum(int a, int b)
			{
				return a+b;
			}
		};
		System.out.println(add1.getSum(4, 9));
	}

}

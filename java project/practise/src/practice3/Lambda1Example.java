package practice3;

interface Message
{
	public void getMessage();
}

public class Lambda1Example {

	public static void main(String[] args) {
		
//		Message msg = new Message() {
//			public void getMessage()
//			{
//				System.out.println("Sample Message");
//			}
//		};
//		
//		msg.getMessage();
		
		Message msg = () -> System.out.println("Sample Message");
		
		msg.getMessage();

	}

}

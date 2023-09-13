package practice3;

public class LambdaThread {

	public static void main(String[] args) {
		
		Runnable runn = new Runnable() {
			
			public void run()
			{
				System.out.println("Thread is Running");
			}
		};
		
		Thread t1 = new Thread(runn);
		t1.start();
		
		Runnable runnable = () -> {
			System.out.println("Thread is running using Lambda");
		};
		
		Thread t2 = new Thread(runnable);
		t2.start();

	}

}
